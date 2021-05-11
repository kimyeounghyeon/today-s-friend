package member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

@WebServlet("/page/member/update")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HttpServlet httpServlet;
	
       
    public MemberUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	private void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int result = 0;
		
		Member vo = new Member();
		String id = request.getParameter("id");
		
		if (id != null && !id.equals("")) {
			vo.setPasswd(request.getParameter("pswd1")); 
			vo.setPhone(request.getParameter("phone"));
			vo.setAge(Integer.parseInt(request.getParameter("age")));
			vo.setEmail(request.getParameter("email"));
			vo.setId(request.getParameter("id"));
		}
		
		result = new MemberService().memberupdate(vo);
		PrintWriter out = response.getWriter();
		
		if (result > 0) { 
			out.println("<script>alert('회원정보수정 성공');</script>");
			request.getRequestDispatcher("page/member/myPageIndex").forward(request, response);
		}else {
			System.out.println("회원정보수정 실패");
			out.println("<script>history.back();</script>");
		}
		
	}
}