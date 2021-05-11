package member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

@WebServlet("/page/indexpage/gradeup")
public class MemberGradeUpServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public MemberGradeUpServlet() {
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
	  PrintWriter out=response.getWriter();
	  Member vo = new Member();
      MemberService sv = new MemberService();
      String id = "";
      int mpoint = 0;
      int result = 0;
      
      String search = request.getParameter("keyword");
      System.out.println("search: " + search);
      
      String[] ids = request.getParameterValues("item");

      if(ids != null && !ids.equals("")) {
         for (int i = 0; i < ids.length; i++) {
            System.out.println("id [] : " + ids.length);
            System.out.println("id [] : " + ids[i]);
            vo = new Member();
            Member list = null;
            vo.setId(ids[i]);
            list = sv.loginAndReadMember(vo);
            id = list.getId();
            mpoint = list.getMpoint();
            System.out.println("list id" + id);
            System.out.println("list mpoint" + mpoint);
            result = sv.gradeUp(vo, id, mpoint);
         }
      } else {
         ids = null;
      }      
      
      if (result == 1) {
         System.out.println("회원 등업 성공");
         out.println("<script>alert('등업이 완료되었습니다.'); location.href='/semiproject/page/indexpage/point';</script>");
//       request.getRequestDispatcher("/page/indexpage/point").forward(request, response);
      } else {
         System.out.println(result);
         System.out.println("등업 실패");
      }

   }

}