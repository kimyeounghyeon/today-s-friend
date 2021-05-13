package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;

/**
 * Servlet implementation class BoardReadServlet
 */
@WebServlet("/page/board/simread")
public class BoardReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardReadServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Board vo = null;
	        Board resultVo = null;
	        BoardService sv = new BoardService();
	        int bno= 0;

	        bno = Integer.parseInt(request.getParameter("bno"));
	        System.out.println("bno 잘 들어왔나요?" + bno);

	        if(bno!=0) {
	                vo = new Board();
	                vo.setBno(bno);
	                resultVo = sv.boardRead(vo);
	                request.setAttribute("board", resultVo);
	                
	                request.getRequestDispatcher("/page/board/boardupdate").forward(request, response);
	            
	        } else {
	            System.out.println("리드가 안됐어요?");
	        }
	}
}
