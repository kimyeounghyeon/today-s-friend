package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;
import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberDeleteServlet
 */
@WebServlet("/page/member/delete3")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberDeleteServlet() {
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
		PrintWriter out = response.getWriter();
		Member vo = new Member();
		MemberService sv = new MemberService();
		
		String id = request.getParameter("id");
		int result = 0;
		vo.setId(request.getParameter("id"));
		result = sv.memberdelete(vo);
		if (result == 1) {
			System.out.println("회원 삭제 성공");
			out.println("<script>alert('삭제가 완료되었습니다.'); location.href='semiproject/page/indexpage/logout';</script>");
		} else {
			System.out.println(result);
			System.out.println("삭제 실패");
		}
	}
}
