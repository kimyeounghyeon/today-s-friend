package comment.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;
import comment.model.service.CommentService;
import comment.model.vo.Comment;

/**
 * Servlet implementation class BoardReadOneServlet
 */
@WebServlet("/page/comment/commentlist")
public class CommentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CommentListServlet() {
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
 		Board vo = null;
 		Comment commentVO = null;
 		
        vo = new Board();
        commentVO = new Comment();
        int bno = 0;

        String strbno = request.getParameter("bno");

        if (strbno != null && !strbno.equals("")) {
            bno = Integer.parseInt(strbno);
            vo.setBno(bno);
            commentVO.setBno(bno);

            Board resultVo = new BoardService().boardRead(vo);

            try {
                List<Comment> commentVOList = new CommentService().commentVOList(commentVO);

                if (commentVOList != null && commentVOList.size() > 0) {
                }else {
                	commentVOList=null;
                }
                request.setAttribute("board", resultVo);
                request.setAttribute("comment", commentVOList);
                request.getRequestDispatcher("/page/board/boardread.jsp").forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("bno 없어ㅠ");
        }
    }
}