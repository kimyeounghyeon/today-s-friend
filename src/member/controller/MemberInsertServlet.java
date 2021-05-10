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

@WebServlet("/page/indexPage/insertmember")
public class MemberInsertServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

    public MemberInsertServlet() {
        super();
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      RequestDispatcher view = null;
      view = request.getRequestDispatcher("/page/member/join.jsp");
      view.forward(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("포스트");
      Member vo = new Member();
      
      vo.setId(request.getParameter("id")); 
      vo.setPasswd(request.getParameter("pswd1"));
      vo.setName(request.getParameter("name")); 
      vo.setEmail(request.getParameter("email"));
      vo.setGender(request.getParameter("gender").charAt(0));
      vo.setLocnum(Integer.parseInt(request.getParameter("local")));
      vo.setPhone(request.getParameter("phone"));
      vo.setAge(Integer.parseInt(request.getParameter("age")));
      vo.toString();
      System.out.println(vo);
      int result = new MemberService().insert(vo);
      System.out.println("리절트값" + result);
      
      PrintWriter out = response.getWriter();
      if(result>0) {  // 정상적으로 insert 성공
          out.println("<script>alert('회원가입에 성공하였습니다'); location.href='/semiproject/page/indexPage/main';</script>");
          System.out.println("성공");
      } else {  // insert 실패
          out.println("<script>alert('회원가입을 실패하였습니다); location.href='/semiproject/page/indexPage/main';</script>");
          System.out.println("실패");
      }
   }
}