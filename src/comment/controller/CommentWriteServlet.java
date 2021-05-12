package comment.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import comment.model.dao.CommentDao;
import comment.model.service.CommentService;
import comment.model.vo.Comment;


@WebServlet("/page/comment/commentwrite")
public class CommentWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		execute(request, response);
	}
	
	private void execute(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException{
		
		Comment commentVO = null;
		commentVO = new Comment(); 
		CommentService sv = null;
		sv = new CommentService();
		PrintWriter out = response.getWriter();

		String rlist = "";
		int result = 0;
		String strbno = request.getParameter("bno");
		if(strbno!=null&&!strbno.equals("")) {
			int bno = Integer.parseInt(strbno);
			commentVO.setBno(bno);
			String id = request.getParameter("id");
			String recontent = request.getParameter("recontent");
			commentVO.setId(id);
			commentVO.setRecontent(recontent);
		}
		
		try {
			result = sv.addComment(commentVO);
			
			if(result==1) {
				System.out.println("댓글 인서트 됨");
				request.getRequestDispatcher("/page/comment/commentlist").forward(request, response);				
			}else {
				System.out.println("댓글 인서트 안됐음?");
				out.println("<script>alert('댓글 작성에 실패했습니다.'); history.back();</script>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
