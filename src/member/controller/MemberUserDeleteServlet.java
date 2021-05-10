package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.dao.MemberDao;
import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberGradeUpServlet
 */
@WebServlet("/page/indexpage/delete")
public class MemberUserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUserDeleteServlet() {
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
	
		
		MemberService md = new MemberService();
		Member vo = new Member();
		
		int result = 0;
		
		String userid = "";
		String id = request.getParameter("id");
		
		result = md.memberDelete(vo, userid);
		
	
		if(result == 1) {
			System.out.println("삭제성공");
			request.getRequestDispatcher("boardList.do").forward(request, response);
		
		
		}
	
	}

}
