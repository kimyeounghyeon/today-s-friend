package comment.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.model.service.CommentService;
import comment.model.vo.Comment;

@WebServlet("/page/comment/commentdelete")
public class CommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CommentDeleteServlet() {
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

	private void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Comment commentVO = null;
		commentVO = new Comment();
		CommentService sv = null;
		sv = new CommentService();

		int result = 0;
		String strreno = request.getParameter("reno");
		
		System.out.println("strreno" + strreno);
		System.out.println("strbno" + request.getParameter("bno"));
		if (strreno != null && !strreno.equals("")) {
			int reno = Integer.parseInt(strreno);
			commentVO.setReno(reno);

			try {
				result = sv.deleteComment(commentVO);
				System.out.println("result" + result);
				if (result == 1) {
					System.out.println("삭제 성공");
					request.getRequestDispatcher("/page/comment/commentlist").forward(request, response);
				} else {
					System.out.println("삭제 실패");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}