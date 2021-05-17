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
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 게시판 주제, 지역별 총 게시글 카운트
	public int getBoardCount(Connection conn, String search, int hobbyId, int locnum) {
		int cnt = 0;
		String sql = "SELECT COUNT(*) FROM BOARD WHERE HOBBYID=? AND LOCNUM = ?";
		if (search != null) {
			sql += " AND BSUBJECT LIKE '%" + search + "%' OR BCONTENT LIKE '%" + search + "%'";
		}

		pstmt = null;
		rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hobbyId);
			pstmt.setInt(2, locnum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	// 차트를 위한 하비 아이디 별 총 카운트
	public int getBoardAllCount(Connection conn, int hobbyId) {
		int cnt = 0;
		String sql = "SELECT COUNT(*) FROM BOARD WHERE HOBBYID=?";

		pstmt = null;
		rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hobbyId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	// 게시판 리드, 페이징
	public List<Board> getBoardByPage(Connection conn, int hobbyId, int locnum, int startRnum, int endRnum,
			String search) {
		List<Board> list = null;
		String sql_1 = "(SELECT * FROM BOARD WHERE HOBBYID = " + hobbyId + " AND LOCNUM = " + locnum;

		if (search == null) {
			sql_1 += " ORDER BY BDATE DESC) D";
		} else {
			sql_1 += " AND BSUBJECT LIKE '%" + search + "%' OR BCONTENT LIKE '%" + search + "%'"
					+ " ORDER BY BDATE DESC) D";
		}

		String sql = "SELECT * FROM (SELECT ROWNUM N, E.* FROM " + " (SELECT ROWNUM R, D.* FROM " + sql_1
				+ " ORDER BY R DESC)E)" + " WHERE R >= ? AND R <= ? ORDER BY N DESC";

		pstmt = null;
		rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRnum);
			pstmt.setInt(2, endRnum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				list = new ArrayList<Board>();
				do {
					Board vo = new Board();

					vo.setFbno(rs.getInt("N"));
					vo.setBno(rs.getInt("bno"));
					vo.setBsubject(rs.getString("bsubject"));
					vo.setBcontent(rs.getString("bcontent"));
					vo.setBdate(rs.getDate("bdate"));
					vo.setId(rs.getString("id"));
					vo.setBfilePath(rs.getString("bfilePath"));
					vo.setHobbyId(rs.getInt("hobbyId"));
					vo.setLocNum(rs.getInt("locnum"));

					list.add(vo);

				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		System.out.println("리턴전list" + list);
		return list;
	}

	// 글 작성
	public int boardWrite(Connection conn, Board vo) {
		int result = 0;
		int max = 1;

		// bno 알아오기
		String sqlMaxBno = "SELECT NVL(MAX(BNO),0)+1 FROM BOARD";

		// 원글
		String sql = "INSERT INTO BOARD VALUES(?, ?, ?, " + " DEFAULT, ?, ?, ?, ?)";

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

	// 글 삭제
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
		} finally {
			close();
		}

		return result;
	}

	// 1개의 글 리드시
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
				resultVO.setHobbyId(rs.getInt("hobbyId"));
				resultVO.setLocNum(rs.getInt("locNum"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return resultVO;
	}

	// 글 수정
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

	// 내가 쓴 글 리스트
	public List<Board> myboardlist(Connection conn, int startRnum, int endRnum, Board vo) {
		List<Board> list = null;
		String sql_1 = "(SELECT * FROM BOARD WHERE ID = ? ORDER BY BDATE DESC)D";

		String sql = "SELECT * FROM " + " (SELECT ROWNUM R, D.* FROM " + sql_1 + " ) " + " WHERE R >= ? AND R <= ?";

		pstmt = null;
		rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setInt(2, startRnum);
			pstmt.setInt(3, endRnum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				list = new ArrayList<Board>();
				do {
					Board ResultVO = new Board();
					ResultVO.setHobbyId(rs.getInt("hobbyId"));
					ResultVO.setBsubject(rs.getString("bsubject"));
					ResultVO.setBcontent(rs.getString("bcontent"));
					ResultVO.setBdate(rs.getDate("bdate"));
					ResultVO.setBno(rs.getInt("bno"));
					list.add(ResultVO);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	// 내가 쓴 글 카운트
	public int getMyBoardCount(Connection conn, Board vo) {
		int cnt = 0;
		String sql = "SELECT COUNT(*) FROM BOARD WHERE ID = ?";

		pstmt = null;
		rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	// 모든 글 리스트
	public List<Board> allBoardRead(Connection conn, int startRnum, int endRnum) {

		List<Board> list = null;
		String sql_1 = "(SELECT * FROM BOARD ORDER BY BDATE DESC)D";

		String sql = "SELECT * FROM " + " (SELECT ROWNUM R, D.* FROM " + sql_1 + " ) " + " WHERE R >= ? AND R <= ?";

		pstmt = null;
		rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRnum);
			pstmt.setInt(2, endRnum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				list = new ArrayList<Board>();
				Board vo = new Board();
				do {

					vo = new Board();

					vo.setId(rs.getString("id"));
					vo.setBno(rs.getInt("bno"));
					vo.setHobbyId(rs.getInt("hobbyId"));
					vo.setLocNum(rs.getInt("locnum"));
					vo.setBsubject(rs.getString("bsubject"));
					vo.setBcontent(rs.getString("bcontent"));
					vo.setBdate(rs.getDate("bdate"));
					list.add(vo);
					
				} while (rs.next());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	// 모든 글 카운트
	public int getAllBoardCount(Connection conn) {
		int cnt = 0;
		String sql = "SELECT COUNT(*) FROM BOARD";

		pstmt = null;
		rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
}