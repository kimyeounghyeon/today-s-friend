package board.controller;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;

@WebServlet("/page/board/update")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardUpdateServlet() {
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
		int result = 0;
		Board vo = new Board();
		String bno = request.getParameter("bno");

		System.out.println(request.getParameter("bsubject"));
		System.out.println(request.getParameter("bcontent"));
		System.out.println(request.getParameter("bfilepath"));
		System.out.println(request.getParameter("bno"));
		

		if (bno != null && !bno.equals("")) {
			vo.setBno(Integer.parseInt(request.getParameter("bno")));
			vo.setBsubject(request.getParameter("bsubject"));
			vo.setBcontent(request.getParameter("bcontent"));
			vo.setBfilePath(request.getParameter("bfilepath"));
		}
		int hobbyId = Integer.parseInt(request.getParameter("hobbyId"));
		result = new BoardService().boardupdate(vo);
		PrintWriter out = response.getWriter();


		if (result == 1) {
			System.out.println("dddd");
			String msg = "글 수정 완료";
			out.println("<script>alert('" + msg + "')</script>");
			request.getRequestDispatcher("/page/board/boardread?hobbyId="+hobbyId).forward(request, response);
		} else {
			System.out.println("adadad");
			String msg = "글 수정 실패하였습니다!";
			out.println("<script>alert('" + msg + "')</script>");
			out.println("<script>history.back();</script>");
		}

	}

}