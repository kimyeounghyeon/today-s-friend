package board.model.service;

import static common.JDBCPool.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import board.model.dao.BoardDao;
import board.model.vo.Board;
import member.model.dao.MemberDao;
import member.model.vo.Member;

public class BoardService {

	// 글 작성
	public int boardWrite(Board vo) {
		int result = 0;
		Connection conn = getConnection();
		try {
			result = new BoardDao().boardWrite(conn, vo);
			if (result != 0) {
				commit(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close(conn);
		return result;
	}

	// 게시판 주제, 지역별 총 게시글 카운트
	public int getBoardCount(String search, int hobbyId, int locnum) {
		Connection conn = getConnection();
		int result = new BoardDao().getBoardCount(conn, search, hobbyId, locnum);
		close(conn);
		return result;
	}

	// 차트를 위한 하비 아이디 별 총 카운트
	public int getBoardAllCount(int hobbyId) {
		Connection conn = getConnection();
		int result = new BoardDao().getBoardAllCount(conn, hobbyId);
		close(conn);
		return result;
	}

	// 게시판 리드, 페이징
	public List<Board> getBoardByPage(int hobbyId, int locnum, int startRnum, int endRnum, String search) {
		Connection conn = getConnection();
		List<Board> list = new BoardDao().getBoardByPage(conn, hobbyId, locnum, startRnum, endRnum, search);
		close(conn);
		return list;
	}

	// 글 삭제
	public int boardDelete(Board vo) {
		int result = 0;
		Connection conn = getConnection();
		try {
			result = new BoardDao().boardDelete(conn, vo);

			if (result != 0) {
				commit(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close(conn);
		return result;
	}

	// 글 수정
	public int boardupdate(Board vo) {
		Connection conn = getConnection();
		int result = 0;

		try {
			result = new BoardDao().boardupdate(conn, vo);
			if (result != 0) {
				commit(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close(conn);
		return result;

	}

	// 1개의 글 리드시
	public Board boardRead(Board vo) {
		Board result = null;
		Connection conn = getConnection();
		try {
			result = new BoardDao().boardRead(conn, vo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		close(conn);
		return result;
	}

	// 내가 쓴 글 리스트
	public List<Board> myboardlist(int startRnum, int endRnum, Board vo) {
		Connection conn = getConnection();
		List<Board> list = new BoardDao().myboardlist(conn, startRnum, endRnum, vo);
		close(conn);
		return list;

	}

	// 내가 쓴 글 카운트
	public int getMyBoardCount(Board vo) {
		Connection conn = getConnection();
		int result = new BoardDao().getMyBoardCount(conn, vo);
		close(conn);
		return result;
	}

	// 모든 글 리스트
	public List<Board> allBoardRead(int startRnum, int endRnum) {
		Connection conn = getConnection();
		List<Board> list = new BoardDao().allBoardRead(conn, startRnum, endRnum);
		close(conn);
		return list;
	}

	// 모든 글 카운트
	public int getAllBoardCount() {
		Connection conn = getConnection();
		int result = new BoardDao().getAllBoardCount(conn);
		close(conn);
		return result;
	}

}
