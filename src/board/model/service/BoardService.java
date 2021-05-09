package board.model.service;

import static common.JDBCPool.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import board.model.dao.BoardDao;
import board.model.vo.Board;

public class BoardService {

//	public List<Board> getBoardAll(int hobbyId) throws SQLException{
//		Connection conn = getConnection();
//		List<Board> list = new BoardDao().getBoardAll(hobbyId,conn);
//		close(conn);
//		return list;
//	}

	public int boardWrite(Board vo) {
		Connection conn = getConnection();
		int result = 0;
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

	public int getBoardCount(String search) {
		Connection conn = getConnection();
		int result = new BoardDao().getBoardCount(conn, search);
		close(conn);
		return result;
	}

	public List<Board> getBoardByPage(int start, int end, String search, int hobbyId) {
		Connection conn = getConnection();
		List<Board> list = new BoardDao().getBoardByPage(conn, start, end, search, hobbyId);
		close(conn);
		return list;
	}

	public int boardDelete(Board vo) {
		Connection conn = getConnection();
		int result = 0;
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
}