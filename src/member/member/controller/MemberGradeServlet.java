package member.controller;

import java.io.IOException;
import java.util.ArrayList;

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
		ArrayList<Member> list = null;
		Member resultVO = new Member();

		/********** 검색 *************/
		String search = request.getParameter("keyword");
		System.out.println("search: " + search);
		
		
		if(search != null && !search.equals("")) {
		} else {
			search = null;
		}
		list = sv.memberPoint(search);
		
		
		if(list != null && list.size() > 0 ) {
			System.out.println("조회 성공");
			
		} else {
			System.out.println("조회 실패");
			}
		
		
		request.setAttribute("mlist", list);
		request.setAttribute("search", search);
		request.getRequestDispatcher("/page/admin/adminPageGrade.jsp").forward(request, response);

		
		
	}
}

