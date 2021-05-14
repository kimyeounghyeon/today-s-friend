package comment.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import comment.model.service.CommentService;
import comment.model.vo.Comment;

@WebServlet("/page/comment/readcommnet")
public class CommentReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CommentReadServlet() {
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

		Comment commentVO = null;
		commentVO = new Comment();
		CommentService sv = null;
		sv = new CommentService();
		Comment resultVo = null;

		String strreno = request.getParameter("reno");
		
		if (strreno != null && !strreno.equals("")) {
			int reno = Integer.parseInt(strreno);
			commentVO.setReno(reno);

			try {
				resultVo = sv.readComment(commentVO);
				
				if (resultVo != null) {
					JSONObject jobj = new JSONObject();
					jobj.put("recontent", resultVo.getRecontent());
					jobj.put("reno", resultVo.getReno());
					jobj.put("bno", resultVo.getBno());
					
					PrintWriter out = response.getWriter();
					out.println(jobj.toJSONString());
					out.flush();
					out.close();
				} else {
					System.out.println("vo가 널");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
