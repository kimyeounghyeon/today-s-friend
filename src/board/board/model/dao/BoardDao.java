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

	public List<Board> getBoardAll(int hobbyId, Connection conn) throws SQLException{
		List<Board> list = null;
		String sql = "SELECT * FROM BOARD WHERE HOBBYID = ? ORDER BY BDATE DESC";
		pstmt = null;
		rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hobbyId);
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
					vo.setHobbyId(hobbyId);
					list.add(vo);					
				}while(rs.next());
			}
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public int boardWrite(Connection conn, Board vo) {
		int result = 0;
		int max = 1;

		// bno 알아오기
		String sqlMaxBno = "SELECT NVL(MAX(BNO),0)+1 FROM BOARD";

		// 원글
		String sql = "INSERT INTO BOARD VALUES(?, ?, ?, " 
				+ " CURRENT_TIMESTAMP, ?, ?, ?, ?)";

		pstmt = null;
		rs = null;

		try {
			// Bno를 알아오는 부분
			pstmt = conn.prepareStatement(sqlMaxBno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				max = rs.getInt(1);
			} else {
				System.out.println("응?");
				return 0;
			}

			JDBCTemplate.close(rs);
            JDBCTemplate.close(pstmt);
			
			// 글 작성
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, max);
			pstmt.setString(2, vo.getBsubject());
			pstmt.setString(3, vo.getBcontent());
			pstmt.setDate(4, vo.getBdate());
			pstmt.setString(5, vo.getId());
			pstmt.setString(6, vo.getBfilePath());
			pstmt.setInt(7, vo.getLocNum());
			pstmt.setInt(8, vo.getHobbyId());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
            JDBCTemplate.close(pstmt);
		}

		return result;
	}

}