package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;
import admin.model.vo.Grade;

@WebServlet("/page/indexpage/point")
public class AdminMemberGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminMemberGradeServlet() {
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

	protected void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminService sv = new AdminService();
		Grade GradeVO = new Grade();
		List<Grade> list = null;

		String search = request.getParameter("keyword");
		System.out.println("search: " + search);

		if (search != null && !search.equals("")) {
		} else {
			search = null;
		}
		
		if (GradeVO != null) {
			System.out.println("조회 성공");

		} else {
			System.out.println("조회 실패");
		}

		System.out.println(GradeVO);

		int cnt = 0;

		final int pageSize = 15;
		final int pageBlock = 5;

		cnt = sv.getGradeCount(search);

		int pageCnt = (cnt / pageSize) + (cnt % pageSize == 0 ? 0 : 1);

		int currentPage = 1;
		String pageNum = request.getParameter("pageNum");
		if (pageNum != null && !pageNum.equals("")) {
			try {
				currentPage = Integer.parseInt(pageNum);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			currentPage = 1;
		}

		int startPage = 1;
		int endPage = 1;

		if (currentPage % pageBlock == 0) {
			startPage = ((currentPage / pageBlock) - 1) * pageBlock + 1;
		} else {
			startPage = (currentPage / pageBlock) * pageBlock + 1;
		}
		endPage = startPage + pageBlock - 1;
		if (endPage > pageCnt)
			endPage = pageCnt;

		int start = (currentPage - 1) * pageSize + 1;
		int end = start + pageSize - 1;
		if (end > cnt)
			end = cnt;

		list = sv.getGradeByPage(start, end, search);

		request.setAttribute("mlist", list);
		request.setAttribute("search", search);
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("currentPage", currentPage);
		request.getRequestDispatcher("/page/admin/adminPageGrade.jsp").forward(request, response);
	}

}