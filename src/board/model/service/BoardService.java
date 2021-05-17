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

	public int getBoardCount(String search, int hobbyId, int locnum) {
		Connection conn = getConnection();
		int result = new BoardDao().getBoardCount(conn, search, hobbyId, locnum);
		close(conn);
		return result;
	}

	public List<Board> getBoardByPage(int hobbyId, int locnum, int startRnum, int endRnum, String search) {
		Connection conn = getConnection();
		List<Board> list = new BoardDao().getBoardByPage(conn, hobbyId, locnum, startRnum, endRnum, search);
		close(conn);
		return list;
	}

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

	public List<Board> myboardlist(int startRnum, int endRnum, Board vo) {
		Connection conn = getConnection();
		List<Board> list = new BoardDao().myboardlist(conn, startRnum, endRnum, vo);
		close(conn);
		return list;

	}
//	public List<Board> myBoardRead1(Board vo) {
//		Connection conn = getConnection();
//		List<Board> list = new BoardDao().myboardRead1(conn, vo);
//		close(conn);
//		return list;
//		
//	}

	public int getMyBoardCount(Board vo)  {
		Connection conn = getConnection();
		int result = new BoardDao().getMyBoardCount(conn, vo);
		close(conn);
		return result;
	}
}
