package member.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javafx.scene.control.Alert;
import member.member.model.service.MemberService;
import member.member.model.vo.Member;

@WebServlet("/page/indexpage/login")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher view = null;
		view = request.getRequestDispatcher("main");
		view.forward(request, response);
		System.out.println("로그인 페이지는 get 방식을 허용하지 않음");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		RequestDispatcher view = null;
		
		Member vo = new Member();
		vo.setId(id);
		
		Member resultVO = new Member();
		resultVO = new MemberService().loginAndReadMember(vo);
		
		if(resultVO==null) {
			System.out.println("아이디 조회 실패");
			out.println("<script>alert('아이디 또는 비밀번호를 확인해주세요!'); location.href='main'</script>");
		} else if(passwd.equals(resultVO.getPasswd())) {
			System.out.println("유저정보조회성공");
			request.getSession().setAttribute("member", resultVO);
			view = request.getRequestDispatcher("/page/indexPage/main");
			view.forward(request, response);
			out.println("<script>alert('로그인에 성공하였습니다!');</script>");
		} else {
			System.out.println("비밀번호 조회 실패");
			out.println("<script>alert('아이디 또는 비밀번호를 확인해주세요!'); location.href='main'</script>");
		}
	}
}