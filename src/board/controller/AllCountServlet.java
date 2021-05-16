package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;

@WebServlet("/page/board/allcount")
public class AllCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AllCountServlet() {
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
		BoardService sv = new BoardService();
		int hobbyId1 = 1;
		int cnt1 = 0; 
		cnt1 = sv.getBoardCount(hobbyId1);
		
		int hobbyId2 = 2;
		int cnt2 = 0; 
		cnt2 = sv.getBoardCount(hobbyId2);
		
		int hobbyId3 = 3;
		int cnt3 = 0; 
		cnt3 = sv.getBoardCount(hobbyId3);
		
		int hobbyId4 = 4;
		int cnt4 = 0; 
		cnt4 = sv.getBoardCount(hobbyId4);
		
		int hobbyId5 = 5;
		int cnt5 = 0; 
		cnt5 = sv.getBoardCount(hobbyId5);

		request.setAttribute("cnt1", cnt1);		
		request.setAttribute("cnt2", cnt2);		
		request.setAttribute("cnt3", cnt3);		
		request.setAttribute("cnt4", cnt4);		
		request.setAttribute("cnt5", cnt5);		
		request.getRequestDispatcher("/page/select/chart.jsp").forward(request,response);
	}

}
