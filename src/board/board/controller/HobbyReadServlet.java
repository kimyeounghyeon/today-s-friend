package board.board.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.board.model.service.BoardService;
import board.board.model.vo.Board;

@WebServlet("/page/hobby/hobbyread")
public class HobbyReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HobbyReadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService sv = new BoardService();
		List<Board> blist = null;
		
		try {
			blist = sv.getBoardAll();
			System.out.println(blist);			
			request.setAttribute("blist", blist);
			request.getRequestDispatcher("/page/select/exercise.jsp").forward(request, response);
			System.out.println("보냇어용");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}