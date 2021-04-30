package member.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.member.model.service.MemberService;
import member.member.model.vo.Member;

@WebServlet("/loginmember")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = null;
		view = request.getRequestDispatcher("main.jsp");
		view.forward(request, response);
		System.out.println("로그인 페이지는 get 방식을 허용하지 않음");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		RequestDispatcher view = null;
		
		Member vo = new Member();
		vo.setId(id);
		
		Member resultVO = new Member();
		resultVO = new MemberService().login(vo);
		
		if(resultVO==null) {
			System.out.println("유저정보조회실패");
			view = request.getRequestDispatcher("fail.jsp");
			view.forward(request, response);
		} else if(passwd.equals(resultVO.getPasswd())) {
			System.out.println("유저정보조회성공");
			request.getSession().setAttribute("member", resultVO);
			view = request.getRequestDispatcher("afterMain.jsp");
			view.forward(request, response);
		} else {
			System.out.println("비밀번호 조회 실패");
			view = request.getRequestDispatcher("fail.jsp");
			view.forward(request, response);
		}
	
	}

}
