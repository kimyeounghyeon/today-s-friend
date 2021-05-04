package board.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import board.board.model.vo.Board;
import member.common.JDBCTemplate;

public class BoardDao {
	
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public List<Board> getBoardAll(Connection conn) throws SQLException{
		List<Board> list = null;
		String sql = "SELECT * FROM BOARD ORDER BY BDATE DESC";
		pstmt = null;
		rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				list = new ArrayList<Board>();
				do {
					Board vo = new Board();
					vo.setBno(rs.getInt("bno"));
					vo.setBsubject(rs.getString("bsubject"));
					vo.setBcontent(rs.getString("bcontent"));
					vo.setBdate(rs.getDate("bdate"));
					vo.setId(rs.getString("id"));
					vo.setBfilePath(rs.getString("bfilePath"));
					vo.setLocNum(rs.getInt("locNum"));
					vo.setHobbyId(rs.getInt("hobbyId"));
					list.add(vo);					
				}while(rs.next());
			}
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
}
