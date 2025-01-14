package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;
import member.model.dao.MemberDao;
import member.model.service.MemberService;
import member.model.vo.Member;

@WebServlet("/page/indexpage/deletepage")
public class AdminMemberUserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminMemberUserDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Member vo = new Member();
		MemberService sv = new MemberService();
		AdminService asv = new AdminService();
		String id = "";
		int result = 0;
		int phone = 0;
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
	            System.out.println("list id" + id);
	            System.out.println("list pnum" + phone);
	            result = asv.memberDelete(vo, id, phone);
	         }
	      } else {
	         ids = null;
	      }      
	      
	      if (result == 1) {
	         System.out.println("회원 삭제 성공");
	         out.println("<script>alert('삭제가 완료되었습니다.'); location.href='/semiproject/page/indexpage/user';</script>");
	      } else {
	         System.out.println(result);
	         System.out.println("삭제 실패");
		}
	}
}
