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

@WebServlet("/page/admin/admboardmodify")
public class AdminModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminModifyServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		int result = 0;
		Admin vo = new Admin();
		
		String stradmno = request.getParameter("admno");
		String id = request.getParameter("id");
		String admsubject = request.getParameter("admsubject");
		String admcontent = request.getParameter("admcontent");
				
		if(stradmno!=null) {
			vo.setAdmno(Integer.parseInt(stradmno));
			vo.setId(id);
			vo.setAdmsubject(admsubject);
			vo.setAdmcontent(admcontent);

			result = new AdminService().adminupdate(vo);
			if(result==1) {
				System.out.println("공지사항 수정 성공");
				request.getRequestDispatcher("/page/admin/admboardread").forward(request, response);
			} else {
				System.out.println("공지사항 수정 실패");
				request.getRequestDispatcher("/page/admin/admboardread").forward(request, response);
			}
		}			
	}

}