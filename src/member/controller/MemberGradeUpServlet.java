package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberGradeUpServlet
 */
@WebServlet("/page/indexpage/gradeup")
public class MemberGradeUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberGradeUpServlet() {
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
		Member vo = new Member();
		
		
		int gradeid = 0;
		
		String id = request.getParameter("id");
		int mpoint = Integer.parseInt(request.getParameter("mpoint"));
		
		System.out.println("mp" + mpoint);
		System.out.println("gi" + gradeid);
		System.out.println("vo.mp" + vo.getMpoint());
		System.out.println("vo.gi" + vo.getId());
		System.out.println(id);
		
		vo.setMpoint(mpoint);
		vo.setId(id);
		
		
		
		int result = new MemberService().gradeUp(vo);
		if(result == 1) {
			System.out.println("회원 등업 성공");
		} else {
			System.out.println(result);
			System.out.println("등업 실패");
		}
	}
	
	

}
