package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.dao.AdminBoardDao;


@WebServlet("/page/admin/boardwrite")
public class AdminBoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public AdminBoardWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String title= request.getParameter("title");
		String contents= request.getParameter("contents");
		String id = request.getParameter("id");
		AdminBoardDao dao = new AdminBoardDao();
		board.model.vo.AdminBoard vo = new board.model.vo.AdminBoard();
		vo.setAdmsubject(title);
		vo.setAdmcontent(contents);
		vo.setId(id);
		int result = dao.insert(vo);
		if(result>0) {
			System.out.println("넘어오나");
			System.out.println(result);
		}
		
		doGet(request, response);
	}

}
