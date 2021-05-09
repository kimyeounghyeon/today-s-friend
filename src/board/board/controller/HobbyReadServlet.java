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
		int hobbyId = Integer.parseInt(request.getParameter("hobbyId"));
		System.out.println("hobbyId"+hobbyId);
		
		BoardService sv = new BoardService();
		List<Board> blist = null;
		
		try {
			blist = sv.getBoardAll(hobbyId);
			System.out.println(blist);			
			request.setAttribute("blist", blist);
			String page = "";
			
			switch(hobbyId) {
			
			case 1 : 
				page = "/page/select/exercise.jsp";
				break;
			
			case 2 : 
				page = "/page/select/movie.jsp";
				break;
				
			case 3 : 
				page = "/page/select/game.jsp";
				break;
				
			case 4 : 
				page ="/page/select/food.jsp";
				break;
				
			case 5 : 
				page ="/page/select/stock.jsp";
				break;
				
			case 6 : 
				page ="/page/select/freeboard.jsp";
				break;
				
			}	
			request.getRequestDispatcher(page).forward(request, response);
			
			System.out.println("보냇어용");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}