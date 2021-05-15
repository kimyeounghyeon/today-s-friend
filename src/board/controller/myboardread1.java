package board.controller;



import java.io.IOException;
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

/**
 * Servlet implementation class myboardread1
 */
@WebServlet("/page/board/myboardread1")
public class myboardread1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public myboardread1() {
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
//			vo.setId(id);
	
			
			list = sv.myBoardRead1(vo);

			request.setAttribute("blist", list);
			request.getRequestDispatcher("/page/admin/allPageread.jsp").forward(request, response);

		} else {
			System.out.println("리드가 안됐어요?");
		}

	}
}
