package comment.controller;

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
import comment.model.service.CommentService;
import comment.model.vo.Comment;
import member.model.vo.Member;

@WebServlet("/page/member/myreplyread")
public class MyReplyReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyReplyReadServlet() {
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
		final int PAGESIZE = 8; // 한 페이지당 글 수
		final int PAGEBLOCK = 5; // 화면에 나타날 페이지 링크 수 dP) 화면 하단에 1 2 3

		CommentService sv = new CommentService();
		int cnt = 0; // 총 글 개수

		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		String id = member.getId();

		System.out.println("서블릿임 = id 잘 들어왔나요?" + id); // 이렇게 해서

		if (id != null) {
			List<Comment> list = null;
			Board vo = new Board();
			vo.setId(id);

			cnt = sv.getMyReplyCount(id);
			System.out.println("cnt" + cnt);

			int pageCnt = (cnt / PAGESIZE) + (cnt % PAGESIZE == 0 ? 0 : 1); // 총 페이지 개수
			int currentPage = 1; // 현재 페이지. 기본 세팅 1. 클릭되면 바뀌게 됨.
			String pageNum = request.getParameter("pageNum");

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
			if (currentPage % PAGEBLOCK == 0) { // currentPage가 pageBlock 배수인 경우
				startPage = ((currentPage / PAGEBLOCK) - 1) * PAGEBLOCK + 1;
			} else {
				if ((currentPage / PAGEBLOCK) == 0) {
					startPage = 1;
				} else {
					startPage = (currentPage / PAGEBLOCK) * PAGEBLOCK + 1;
				}
			}

			endPage = startPage + PAGEBLOCK - 1;
			// 총 페이지 개수보다 endPage가 더 클 수 없음.
			if (endPage > pageCnt) {
				endPage = pageCnt;
			}

			int startRnum = 0;
			if (currentPage == 1) {
				startRnum = 1;
			} else {
				startRnum = (currentPage - 1) * PAGESIZE + 1;
			}

			int endRnum = startRnum + PAGESIZE - 1;
			if (endRnum > cnt) {
				endRnum = cnt; // 마지막 그
			}

			list = sv.myReplylist(startRnum, endRnum, id);

			request.setAttribute("pageCnt", pageCnt);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("clist", list);
			request.getRequestDispatcher("/page/member/myPageWritingRe.jsp").forward(request, response);

			System.out.println("pageCnt" + pageCnt);
			System.out.println("startPage" + startPage);
			System.out.println("endPage" + endPage);
			System.out.println("currentPage" + currentPage);
			System.out.println("clist" + list);

		} else {
			System.out.println("리드가 안됐어요?");
		}

	}

}
