package board.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.service.BoardService;
import board.model.vo.Board;
import member.model.vo.Member;

@WebServlet("/page/member/myboardread")
public class MyBoardReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyBoardReadServlet() {
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

		
		BoardService sv = new BoardService();
		HttpSession session = request.getSession(); 
		Member member = (Member) session.getAttribute("member");
		String id = member.getId();
		
		System.out.println("서블릿임 = id 잘 들어왔나요?" + id); // 이렇게 해서

		if (id != null) {
			List<Board> list = null;
			Board vo = new Board();
			vo.setId(id);
	
			
			list = sv.myBoardRead(vo);

			request.setAttribute("blist", list);
			request.getRequestDispatcher("/page/member/myPageWriting.jsp").forward(request, response);

		} else {
			System.out.println("리드가 안됐어요?");
		}

	}
}
