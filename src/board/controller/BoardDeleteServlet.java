package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;

/**
 * Servlet implementation class BoardDeleteCtrl
 */
@WebServlet("/page/board/delete1")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		excute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		excute(request, response);
	}

	protected void excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardService sv = new BoardService();
		Board vo = new Board();
		int hobbyId = Integer.parseInt(request.getParameter("hobbyId"));
		vo.setHobbyId(hobbyId);
		
		int result = 0;
		System.out.println("나와 ??");
		vo.setBno(Integer.parseInt(request.getParameter("bno")));
	

		result = sv.boardDelete(vo);
		if(result == 1) {
			System.out.println("삭제성공");
			
			request.getRequestDispatcher("/page/board/boardread?hobbyId="+hobbyId).forward(request, response);
		}else {
			System.out.println("삭제실패");
		}
	}

}
