package member.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import board.model.vo.Board;
import member.model.vo.Member;

public class MemberDao {
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

	// insert()
	public int insert(Connection conn, Member vo) {
		int result = 0;

		String sql = "insert into member values(?,?,?,?,?,?,DEFAULT,?,?,NULL,DEFAULT,DEFAULT,DEFAULT)";
		pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, String.valueOf(vo.getGender()));
			pstmt.setInt(6, vo.getLocnum());
			pstmt.setString(7, vo.getPhone());
			pstmt.setInt(8, vo.getAge());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close();
		}

		return result;
	}

	public Member loginAndReadMember(Connection conn, Member vo) {
		String id = vo.getId();

		String sql = "SELECT * FROM MEMBER WHERE ID=?";

		pstmt = null;
		rs = null;
		Member resultVO = new Member();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				resultVO.setId(id);
				resultVO.setPasswd(rs.getString("Passwd"));
				resultVO.setName(rs.getString("name"));
				resultVO.setLocnum(rs.getInt("locnum"));
				resultVO.setMpoint(rs.getInt("Mpoint"));
				resultVO.setGradeid(rs.getInt("gradeid"));
				resultVO.setPhone(rs.getString("phone"));
				resultVO.setAge(rs.getInt("age"));
				resultVO.setEmail(rs.getString("email"));
				/* resultVO.setGender(char).rs.getString("gender"); */
				resultVO.setLEVnum(rs.getInt("LEVnum"));
				System.out.println("아이디 확인 성공");
			} else {
				System.out.println("아이디 확인 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return resultVO;
	}

	public Member searchIdNPw(Connection conn, Member vo) {
		String email = vo.getEmail();
		String sql = "SELECT * FROM MEMBER WHERE EMAIL=?";
		System.out.println("서치다오" + email);

		pstmt = null;
		rs = null;
		Member resultVO = new Member();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				resultVO.setId(rs.getString("id"));
				resultVO.setPasswd(rs.getString("passwd"));
				resultVO.setName(rs.getString("name"));
				resultVO.setEmail(email);
				System.out.println("이메일 확인 성공");
			} else {
				System.out.println("이메일 확인 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return resultVO;
	}

	public ArrayList<Member> memberPoint(Connection conn, String search) {
		ArrayList<Member> list = null;
		String sql = "select * from member ";

		if (search == null) {
			sql += " order by mpoint";
		} else {
			sql += " where id like '%" + search + "%' order by mpoint";
		}

		pstmt = null;
		rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				list = new ArrayList<Member>();
				do {
					Member ResultVO = new Member();

					ResultVO.setId(rs.getString("id"));
					ResultVO.setName(rs.getString("name"));
					ResultVO.setLocnum(rs.getInt("locnum"));
					ResultVO.setMpoint(rs.getInt("mpoint"));
					ResultVO.setGradeid(rs.getInt("gradeid"));

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

	public int updateMember(Connection conn, Member vo) {

		String sql = "UPDATE Member SET passwd = ?, age = ?, phone = ?, email = ? WHERE id = ?";
		int result = 0;
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPasswd());
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, vo.getPhone());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("하윙");
		} finally {
			close();
		}
		return result;

	}

	public int gradeUp(Connection conn, Member vo, String id, int mpoint) {
		int gradeid = 0;
		int result = 0;

		String sql = "update member set gradeid = ? where id = ?";

		if (0 <= mpoint && mpoint <= 299) {
			gradeid = 1;
		} else if (300 <= mpoint && mpoint <= 999) {
			gradeid = 2;
		} else if (1000 <= mpoint && mpoint <= 2999) {
			gradeid = 3;
		} else if (3000 <= mpoint && mpoint <= 5999) {
			gradeid = 4;
		} else if (6000 <= mpoint && mpoint <= 9999) {
			gradeid = 5;
		}

		pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gradeid);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			close();
		}

		return result;

	}

	public int getMemberCount(Connection conn, String search) {
		int cnt = 0;
		String sql = "SELECT COUNT(*) FROM member";
		if (search != null) {
			sql += " WHERE id LIKE '%" + search + "%'";
		}

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

	public List<Member> getMemberByPage(Connection conn, int start, int end, String search) {
		List<Member> list = null;
		String sql_1 = "(select * from member ";

		if (search == null) {
			sql_1 += " order by mpoint desc) d";
		} else {
			sql_1 += " where id like '%" + search + "%' order by mpoint desc) d";
		}

		String sql = "SELECT * FROM "
				+ " (SELECT ROWNUM R, D.* FROM " + sql_1  + " ) "
				+ " WHERE R >= ? AND R <= ? ";
		
		pstmt = null;
		rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				list = new ArrayList<Member>();
				do {
					Member ResultVO = new Member();

					ResultVO.setId(rs.getString("id"));
					ResultVO.setName(rs.getString("name"));
					ResultVO.setLocnum(rs.getInt("locnum"));
					ResultVO.setMpoint(rs.getInt("mpoint"));
					ResultVO.setGradeid(rs.getInt("gradeid"));
					ResultVO.setPhone(rs.getString("phone"));

					list.add(ResultVO);

					System.out.println("list : " + list);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	public ArrayList<Member> memberUser(Connection conn, String search) {
		ArrayList<Member> list = null;
		String sql = "select * from member ";

		if (search == null) {
			sql += " order by id";
		} else {
			sql += " where id like '%" + search + "%' order by i";
		}

		pstmt = null;
		rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				list = new ArrayList<Member>();
				do {
					Member ResultVO = new Member();

					ResultVO.setId(rs.getString("id"));
					ResultVO.setName(rs.getString("name"));
					ResultVO.setLocnum(rs.getInt("locnum"));
					ResultVO.setPhone(rs.getString("phone"));

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

}