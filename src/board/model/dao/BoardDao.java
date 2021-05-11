package board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import board.model.vo.Board;
import member.model.vo.Member;

public class BoardDao {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private void close() {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(stmt != null) {
				stmt.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * public int boardDelete(Connection conn, Board vo) { int result = 0;
	 * 
	 * String sql = "delete from board where bno = ?";
	 * 
	 * pstmt = null;
	 * 
	 * try { pstmt = conn.prepareStatement(sql); pstmt.setInt(1, vo.getBno());
	 * result = pstmt.executeUpdate();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }finally { close(); }
	 * 
	 * return result; }
	 */
	
	public int getBoardCount(Connection conn, String search) {
		int cnt = 0;
		String sql = "SELECT COUNT(*) FROM BOARD";
		if (search != null) {
			sql += " WHERE BSUBJECT LIKE '%" + search+ "%' OR BCONTENT LIKE '%"+ search+ "%'";
		}
		
		pstmt = null;
		rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
	public List<Board> getBoardByPage(Connection conn, int start, int end, String search, int hobbyId) {
		List<Board> list = null;
		String sql_1= "(SELECT * FROM BOARD ";
		
		if(search == null) {
			sql_1 += " ORDER BY BDATE DESC) D";
		} else {
			sql_1 += " WHERE BSUBJECT LIKE '%" + search+ "%' OR BCONTENT LIKE '%"+ search+ "%'"
					+ " ORDER BY BDATE DESC) D";
		}
		
		String sql = "SELECT * FROM "
					+ " (SELECT ROWNUM R, D.* FROM " + sql_1  + " ) "
					+ " WHERE R >= ? AND R <= ? AND HOBBYID = ? ";
		
		pstmt = null; 
		rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			pstmt.setInt(3, hobbyId);
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
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
				+ " DEFAULT, ?, ?, ?, ?)";

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

			close();
			
			// 글 작성
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, max);
			pstmt.setString(2, vo.getBsubject());
			pstmt.setString(3, vo.getBcontent());
			pstmt.setString(4, vo.getId());
			pstmt.setString(5, vo.getBfilePath());
			pstmt.setInt(6, vo.getLocNum());
			pstmt.setInt(7, vo.getHobbyId());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            close();
		}

		return result;
	}

	public int boardDelete(Connection conn, Board vo) {
		      int result = 0;

		      String sql = "delete from board where bno = ?";

		      pstmt = null;

		      try {
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setInt(1, vo.getBno());
		         result = pstmt.executeUpdate();

		      } catch (Exception e) {
		         e.printStackTrace();
		      }finally {
            close();
		      }

		      return result;
		   }
	public Board boardRead(Connection conn, Board vo) {
		
		int bno = vo.getBno();
		String sql = "select * from board where bno = ?";
		pstmt = null;
		rs = null;
		Board resultVO = new Board();
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			  if (rs.next()) {
				  resultVO.setBno(bno);
	                resultVO.setBsubject(rs.getString("bsubject"));
	                resultVO.setBcontent(rs.getString("bcontent"));
	                resultVO.setBfilePath(rs.getString("bfilePath"));
			  }
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return resultVO;
	}

	public int boardupdate(Connection conn, Board vo) {
		int result = 0;
		String sql = "update board set bsubject = ?, bcontent = ?, bfilepath = ? where bno = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getBsubject());
			pstmt.setString(2, vo.getBcontent());
			pstmt.setString(3, vo.getBfilePath());
			pstmt.setInt(4, vo.getBno());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            close();
		}

		return result;

	}
	
	public Board myboardRead(Connection conn, Board vo, String str) {
		
		System.out.println("str : " + str);
		String id = vo.getId();
		int hobbyId = vo.getHobbyId();
		String sql = "select * from board where id = ? ";
		pstmt = null;
		rs = null;
		Board resultVO = new Board();
		
		System.out.println("Sql : " + sql);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, str);
			//pstmt.setInt(2, hobbyId);
			rs = pstmt.executeQuery();
			System.out.println("Rs  :" + rs);
			/* int i = 1; */
			  if (rs.next()) {
					/*
					 * System.out.println(i+ rs.getString("id")); i++;
					 */
				    //resultVO.setId(id);
					
					  resultVO.setBsubject(rs.getString("bsubject"));
					  resultVO.setBcontent(rs.getString("bcontent"));
					  resultVO.setBfilePath(rs.getString("bfilePath"));
					  resultVO.setLocNum(rs.getInt("locNum"));
					  resultVO.setHobbyId(rs.getInt("hobbyId"));
					 
			  }
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return resultVO;
	}
	
	
}