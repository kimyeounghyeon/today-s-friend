package member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;



/**
 * Servlet implementation class MemberGradeServlet
 */
@WebServlet("/page/indexpage/point")
public class MemberGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberGradeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService sv = new MemberService();
		List<Member> list = null;
		Member resultVO = new Member();
		int start = 1;
		int end = 1;


		String search = request.getParameter("keyword");
		System.out.println("search: " + search);
		
		
		if(search != null && !search.equals("")) {
		} else {
			search = null;
		}
		
		list = sv.getMemberByPage(start, end, search);
		
		
		if(list != null && list.size() > 0 ) {
			System.out.println("조회 성공");
			
		} else {
			System.out.println("조회 실패");
			}
		
		System.out.println(list);
		
		int cnt = 0; // 총 글 개수

		final int pageSize = 15; // 한페이지당 글 수
		final int pageBlock = 5; // 화면에 나타날 페이지 링크 수 dP) 화면 하단에 1 2 3
		

		cnt = sv.getMemberCount(search);

		int pageCnt = (cnt / pageSize) + (cnt % pageSize == 0 ? 0 : 1); // 총 페이지 개수

		int currentPage = 1; // 현재 페이지. 기본 세팅 1. 클릭되면 바뀌게 됨.
		String pageNum = "1";
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

		if (currentPage % pageBlock == 0) { 
			startPage = ((currentPage / pageBlock) - 1) * pageBlock + 1;
		} else {
			startPage = (currentPage / pageBlock) * pageBlock + 1;
		}
		endPage = startPage + pageBlock - 1;
		if (endPage > pageCnt)
			endPage = pageCnt;

		start = (currentPage - 1) * pageSize + 1;
		end = start + pageSize - 1;
		if (end > cnt)
			end = cnt;
		
		
		request.setAttribute("mlist", list);
		request.setAttribute("search", search);
		request.getRequestDispatcher("/page/admin/adminPageGrade.jsp").forward(request, response);

		
		
	}
}

