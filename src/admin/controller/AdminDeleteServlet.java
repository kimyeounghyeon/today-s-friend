package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;
import admin.model.vo.Admin;

@WebServlet("/page/admin/admboarddelete")
public class AdminDeleteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public AdminDeleteServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		excute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		excute(request, response);
	}

	protected void excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		AdminService sv = new AdminService();
		Admin vo = new Admin();
		int result = 0;
		
		String str = request.getParameter("admno");
		if(str!=null&&!str.equals("")) {
			vo.setAdmno(Integer.parseInt(str));
			result = sv.adminDelete(vo);
			System.out.println("result" + result);
			if (result == 1) {
				System.out.println("공지사항 삭제 성공");
				request.getRequestDispatcher("/page/admin/admboardread").forward(request, response);
			} else {
				System.out.println("공지사항 삭제 실패");
				request.getRequestDispatcher("/page/admin/admboardread").forward(request, response);
			}
		}
	}
}
