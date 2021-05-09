package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

@WebServlet("/page/member/search")
public class MemberSearchIdNPwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberSearchIdNPwServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	protected void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		System.out.println("리퀘스트 네임" + name);
		String id = request.getParameter("id");
		System.out.println("리퀘스트 id" + id);
		String email = request.getParameter("email");
		System.out.println("리퀘스트 email" + email);
		
		Member vo = new Member();
		vo.setEmail(email);
		System.out.println("vo email" + vo.getEmail());
		
		Member resultVO = new Member();
		resultVO = new MemberService().searchIdNPw(vo);
		System.out.println("리절트vo id" + resultVO.getId());
		System.out.println("리절트vo pw" + resultVO.getPasswd());
		System.out.println("리절트vo name" + resultVO.getName());
		System.out.println("리절트vo email" + resultVO.getEmail());
		
		if(resultVO==null) {
			System.out.println("이메일 조회 실패");
			out.println("<script>alert('이메일 주소를 다시 확인해주세요!'); history.back();</script>");
		} else if(email.equals(resultVO.getEmail())||id.equals(resultVO.getId())) {
			System.out.println("정보조회성공");
			if(name.equals(resultVO.getName())) {
				out.println("<script>alert('회원 조회에 성공하였습니다! 고객님의 아이디는"+resultVO.getId()+"입니다');location.href='/semiproject/page/indexPage/main';</script>");
			} else {
				out.println("<script>alert('회원 조회에 성공하였습니다! 고객님의 비밀번호는"+resultVO.getPasswd()+"입니다');location.href='/semiproject/page/indexPage/main';</script>");		
			}		
		} else {
			System.out.println("회원 조회 실패");
			out.println("<script>alert('회원 정보 입력을 다시 확인해주세요!'); history.back();</script>");
		}
	}
}