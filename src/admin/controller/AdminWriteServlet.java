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

@WebServlet("/page/admin/admboardwrite")
public class AdminWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminWriteServlet() {
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

	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Admin vo = new Admin();
		AdminService sv = new AdminService();
		
		vo.setAdmsubject(request.getParameter("admsubject"));
		vo.setAdmcontent(request.getParameter("admcontent"));
		vo.setId(request.getParameter("id"));
							
		int result = sv.adminWrite(vo); 

		if(result>0) { // 정상 등록
			System.out.println("공지사항 입력 성공");
			request.getRequestDispatcher("/page/admin/admboardread").forward(request, response);
		} else { // 등록 실패
			System.out.println("공지사항 입력 실패");
			request.getRequestDispatcher("/page/admin/admboardread").forward(request, response);

		}
	}
}