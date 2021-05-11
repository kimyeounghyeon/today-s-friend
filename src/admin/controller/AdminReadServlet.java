package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;
import admin.model.vo.Admin;

@WebServlet("/page/admin/adminread")
public class AdminReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminReadServlet() {
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
		
		AdminService sv = new AdminService();
		Admin vo = new Admin();
		Admin resultVo = null;
		String str = request.getParameter("admno");
		if(str!=null) {
			vo.setAdmno(Integer.parseInt(str));
			resultVo = sv.adminRead(vo);
			
			if(resultVo!=null) {
				request.setAttribute("nlist", resultVo);
				request.getRequestDispatcher("/page/admin/adminBoardContent.jsp").forward(request, response);
			} else {
				System.out.println("글 읽기 실패");
			}
		}			
	}
}
