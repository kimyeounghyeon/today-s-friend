package admin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import admin.model.vo.Admin;

public class AdminDao {

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

	public int getAdminCount(Connection conn) {
		int cnt = 0;
		String sql = "SELECT COUNT(*) FROM ADMINBOARD";

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

	public List<Admin> getAdminByPage(Connection conn, int start, int end) {
		List<Admin> list = null;
		String sql_1 = "(SELECT * FROM ADMINBOARD ORDER BY ADMDATE DESC) D";

		String sql = "SELECT * FROM " + " (SELECT ROWNUM R, D.* FROM " + sql_1 + " ) " + " WHERE R >= ? AND R <= ?";

		pstmt = null;
		rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				list = new ArrayList<Admin>();
				do {
					Admin vo = new Admin();
					vo.setAdmno(rs.getInt("admno"));
					vo.setAdmsubject(rs.getString("admsubject"));
					vo.setAdmcontent(rs.getString("admcontent"));
					vo.setAdmdate(rs.getTimestamp("admdate"));
					vo.setId(rs.getString("id"));
					vo.setAdmfilepath(rs.getString("admfilepath"));
					list.add(vo);
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public Admin adminRead(Connection conn, Admin vo) {

		Admin resultVo = null;
		String sql = "SELECT * FROM ADMINBOARD WHERE ADMNO= ?";
		pstmt = null;
		rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getAdmno());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				resultVo = new Admin();
				resultVo.setAdmno(rs.getInt("admno"));
				resultVo.setAdmsubject(rs.getString("admsubject"));
				resultVo.setAdmcontent(rs.getString("admcontent"));
				resultVo.setAdmdate(rs.getTimestamp("Admdate"));
				resultVo.setId(rs.getString("id"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return resultVo;
	}
	
	public int adminModify(Connection conn, Admin vo) {
		int result = 0;
		String sql = "UPDATE ADMINBOARD SET ID = ?, ADMSUBJECT = ?, ADMCONTENT = ? WHERE ADMNO = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getAdmsubject());
			pstmt.setString(3, vo.getAdmcontent());
			pstmt.setInt(4, vo.getAdmno());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public int adminWrite(Connection conn, Admin vo) {
		int result = 0;
		int max = 1;

		// bno 알아오기
		String sqlMaxAdmno = "SELECT NVL(MAX(ADMNO),0)+1 FROM ADMINBOARD";

		// 원글
		String sql = "INSERT INTO ADMINBOARD VALUES(?, ?, ?, DEFAULT, ?, NULL)";

		pstmt = null;
		rs = null;

		try {
			// Bno를 알아오는 부분
			pstmt = conn.prepareStatement(sqlMaxAdmno);
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
			pstmt.setString(2, vo.getAdmsubject());
			pstmt.setString(3, vo.getAdmcontent());
			pstmt.setString(4, vo.getId());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public int adminDelete(Connection conn, Admin vo) {
		int result = 0;
		String sql = "DELETE FROM ADMINBOARD WHERE ADMNO = ?";
		pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getAdmno());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}
}
