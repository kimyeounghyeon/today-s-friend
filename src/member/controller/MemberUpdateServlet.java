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
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		
		if (id != null && !id.equals("")) {
			vo.setId(id);
			vo.setPasswd(request.getParameter("passwd")); 
			vo.setEmail(request.getParameter("email"));
			vo.setLocnum(Integer.parseInt(request.getParameter("locnum")));
			vo.setPhone(request.getParameter("phone"));
			vo.setAge(Integer.parseInt(request.getParameter("age")));
		}
		
		result = new MemberService().memberupdate(vo);
		
		if (result==1) { 
			System.out.println("회원정보 수정 성공");
			out.println("<script>alert('회원 정보 수정에 성공하였습니다! 다시 한 번 로그인 해주세요!');location.href='/semiproject/page/indexpage/logout';</script>");
		}else {
			System.out.println("회원정보수정 실패");
			out.println("<script>alert('회원 정보 수정에 실패하였습니다 관리자에게 문의해주세요');history.back();</script>");
		}
		
	}
}