package member.controller;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.Date;

import member.model.dao.MemberDao;
import member.model.service.MemberService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/page/member/MemberUpdateServlet")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String passwd, email, phone,id;
	private int age;
	
	HttpServlet httpServlet;
	
       
    public MemberUpdateServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		HttpSession session = request.getSession(); 
		Member info = (Member) session.getAttribute("info"); 
		RequestDispatcher view = null;
	
		
		passwd = request.getParameter("pswd1"); 
		phone = request.getParameter("phone"); 
		age = Integer.parseInt(request.getParameter("age"));
		email = request.getParameter("email");
		id = request.getParameter("id");
		
		
		member.model.vo.Member vo = new member.model.vo.Member();
		vo.setId(id);
		
		member.model.vo.Member resultVO = new member.model.vo.Member();

		//세션값 갱신
		MemberDao dao = new MemberDao(); 
		int result = dao.updateMember(passwd,phone,age,email,id);
		PrintWriter out = response.getWriter();
		resultVO = new MemberService().loginAndReadMember(vo);
		
		  if (result > 0) { 
			  request.getSession().setAttribute("member", resultVO);
			  view = request.getRequestDispatcher("/page/indexPage/main");
			  view.forward(request, response);
			  out.println("<script>alert('회원정보수정이 완료되었습니다.')</script>");
			  out.flush();
			 
			 
		  }else {
			  System.out.println("회원정보수정 실패");
				out.println("<script>alert('회원정보수정에 실패하였습니다.,'); location.href='modify'</script>");
		  }
		 



	}
	

}
