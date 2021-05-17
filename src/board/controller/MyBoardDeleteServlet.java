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

@WebServlet("/page/board/deletemyboard")
public class MyBoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyBoardDeleteServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		excute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		excute(request, response);
	}

	protected void excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardService sv = new BoardService();
		Board vo = new Board();
		

		int result = 0;
		System.out.println("나와 ??");

		vo.setBno(Integer.parseInt(request.getParameter("bno")));
		System.out.println("bno"+request.getParameter("bno"));
		PrintWriter out = response.getWriter();
		result = sv.boardDelete(vo);
		System.out.println("result" + result);
		if (result == 1) {
			String msg = "글  삭제 성공";
			out.println("<script> alert('"+msg+"')</script>");
			out.println("<script>history.back();</script>");
		} else {
			System.out.println("입력 실패");
			String msg = "글 삭제 실패";
			out.println("<script> alert('"+msg+"')</script>");
			out.println("<script>history.back();</script>");
		}
	}
}