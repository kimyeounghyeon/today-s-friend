package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.service.BoardService;
import board.model.vo.Board;
@WebServlet("/MyBoardReadServlet")	
public class MyBoardReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MyBoardReadServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 Board vo = null;
	     Board resultVo = null;
	     BoardService sv = new BoardService();
	     String id = "";
	
	     HttpSession session = request.getSession();				//잘못됨 구글 찾아보기 
	     String myId = (String) session.getAttribute("sessionId");
	     
	    		 
	     
	     System.out.println("id 잘 들어왔나요?" + myId);		//이렇게 해서 
	
	     if(id!=null) {
	             vo = new Board();
	             vo.setId(id);
	             resultVo = sv.myBoardRead(vo, myId);		// 쿼리 가져오는거까지,  쿼리 확인하기
	             System.out.println("resultVo : " + resultVo);
	            // request.setAttribute("sessionId", id);
	            // request.getRequestDispatcher("/page/board/boardupdate").forward(request, response);
	         
	     } else {
	         System.out.println("리드가 안됐어요?");
	     }
}
}
