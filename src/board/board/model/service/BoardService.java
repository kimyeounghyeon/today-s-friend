package board.board.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import board.board.model.dao.BoardDao;
import board.board.model.vo.Board;

import static member.common.JDBCTemplate.*;

public class BoardService {
	
	public List<Board> getBoardAll(int hobbyId) throws SQLException{
		Connection conn = getConnection();
		List<Board> list = new BoardDao().getBoardAll(hobbyId,conn);
		close(conn);
		return list;
	}
	
	public int boardWrite(Board vo) {
		Connection conn = getConnection();
		int result = new BoardDao().boardWrite(conn, vo);
		close(conn);
		return result;
	}
}
