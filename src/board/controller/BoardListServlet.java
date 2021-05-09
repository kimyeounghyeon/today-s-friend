package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import board.model.service.BoardService;
import board.model.vo.Board;

@WebServlet("/page/board/boardread")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardListServlet() {
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
		final int pageSize = 10; // 한페이지당 글 수
		final int pageBlock = 5; // 화면에 나타날 페이지 링크 수 dP) 화면 하단에 1 2 3
		System.out.println("하비아이디" + request.getParameter("hobbyId"));
		int hobbyId = Integer.parseInt(request.getParameter("hobbyId"));

		BoardService sv = new BoardService();

		int cnt = 0; // 총 글 개수
		/********** 검색 *************/
		String search = request.getParameter("search");
		System.out.println("search: " + search);

		if (search != null && !search.equals("")) {
		} else {
			search = null;
		}
		cnt = sv.getBoardCount(search);

		int pageCnt = (cnt / pageSize) + (cnt % pageSize == 0 ? 0 : 1); // 총 페이지 개수

		int currentPage = 1; // 현재 페이지. 기본 세팅 1. 클릭되면 바뀌게 됨.
		String pageNum = request.getParameter("pageNum");
		System.out.println("pageNum" + pageNum);
		if (pageNum != null && !pageNum.equals("")) { // 클린 된 숫자를 가지고 온다면
			try {
				currentPage = Integer.parseInt(pageNum);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			currentPage = 1;
		}

		int startPage = 1; // 화면에 나타날 시작 페이지
		int endPage = 1; // 화면에 나타날 마지막 페이지

		// 문제 구간 생김. currentPage가 pageBlock 배수인 경우 오류 발생 즉, 3,6,9..
		if (currentPage % pageBlock == 0) { // currentPage가 pageBlock 배수인 경우
			startPage = ((currentPage / pageBlock) - 1) * pageBlock + 1;
		} else {
			startPage = (currentPage / pageBlock) * pageBlock + 1;
		}
		endPage = startPage + pageBlock - 1;
		// 총 페이지 개수보다 endPage가 더 클 수 없음.
		if (endPage > pageCnt)
			endPage = pageCnt;

		int start = (currentPage - 1) * pageSize + 1;
		int end = start + pageSize - 1;
		if (end > cnt)
			end = cnt;

		List<Board> list = null;
		/********** 검색 *************/

		list = sv.getBoardByPage(start, end, search, hobbyId);

		// ajax 아닌 경우 기존 처럼 forward 하면 됨.
		System.out.println("search" + search);
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("blist", list);
		request.setAttribute("search", search);

		String page = "";

		switch (hobbyId) {

		case 1:
			page = "/page/select/exercise.jsp";
			break;

		case 2:
			page = "/page/select/movie.jsp";
			break;

		case 3:
			page = "/page/select/game.jsp";
			break;

		case 4:
			page = "/page/select/food.jsp";
			break;

		case 5:
			page = "/page/select/stock.jsp";
			break;

		case 6:
			page = "/page/select/freeboard.jsp";
			break;

		}
		request.getRequestDispatcher(page).forward(request, response);
	}
}
