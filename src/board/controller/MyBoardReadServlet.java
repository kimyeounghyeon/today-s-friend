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

import admin.model.service.AdminService;
import board.model.service.BoardService;
import board.model.vo.Board;
import member.model.service.MemberService;

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

		Board vo = null;
		Board resultVo = null;
		MemberService sv = new MemberService();
		String id = "";
		Date bdate = null;
		int hobbyid = 0;
		HttpSession session = request.getSession(); // 잘못됨 구글 찾아보기
		String myId = (String) session.getAttribute("sessionId");

		System.out.println("id 잘 들어왔나요?" + myId); // 이렇게 해서

		if (id != null) {
			List<Board> list = null;
			vo = new Board();
			vo.setId(id);
			list = sv.myBoardRead(vo, myId, hobbyid, bdate);
			System.out.println("list  : " + list);

			request.setAttribute("blist", list);

			request.getRequestDispatcher("/page/member/myPageWriting.jsp").forward(request, response);

		} else {
			System.out.println("리드가 안됐어요?");
		}
	}
}
