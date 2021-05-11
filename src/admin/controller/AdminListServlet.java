package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;
import admin.model.vo.Admin;

@WebServlet("/page/admin/admboardread")
public class AdminListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	private void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		final int pageSize = 10; // 한페이지당 글 수
		final int pageBlock = 5; // 화면에 나타날 페이지 링크 수 dP) 화면 하단에 1 2 3
		
		AdminService sv = new AdminService();

		int cnt = 0; // 총 글 개수
		/********** 검색 *************/
		cnt = sv.getAdminCount();

		int pageCnt = (cnt / pageSize) + (cnt % pageSize == 0 ? 0 : 1); // 총 페이지 개수

		int currentPage = 1; // 현재 페이지. 기본 세팅 1. 클릭되면 바뀌게 됨.
		String pageNum = request.getParameter("pageNum");
		if (pageNum != null && !pageNum.equals("")) { // 클린 된 숫자를 가지고 온다면
			try {
				currentPage = Integer.parseInt(pageNum);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			currentPage = 1;
		}

		int startPage = 1; // 화면에 나타날 시작 페이지
		int endPage = 1; // 화면에 나타날 마지막 페이지

		// 문제 구간 생김. currentPage가 pageBlock 배수인 경우 오류 발생 즉, 3,6,9..
		if (currentPage % pageBlock == 0) { // currentPage가 pageBlock 배수인 경우
			startPage = ((currentPage / pageBlock) - 1) * pageBlock + 1;
		} else {
			startPage = (currentPage / pageBlock) * pageBlock + 1;
		}
		endPage = startPage + pageBlock - 1;
		// 총 페이지 개수보다 endPage가 더 클 수 없음.
		if (endPage > pageCnt)
			endPage = pageCnt;

		int start = (currentPage - 1) * pageSize + 1;
		int end = start + pageSize - 1;
		if (end > cnt)
			end = cnt;

		List<Admin> list = null;
		/********** 검색 *************/
		list = sv.getAdminByPage(start, end);
		
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("nlist", list);
		request.getRequestDispatcher("/page/admin/adminBoard.jsp").forward(request,response);
		}
}
