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
				resultVO.setGender(rs.getString("gender").charAt(0));
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

	public int updateMember(Connection conn, Member vo) {

		String sql = "UPDATE MEMBER SET PASSWD = ?, EMAIL = ?, LOCNUM = ?, PHONE = ?, AGE = ?, AGEID = ? WHERE ID = ?";
		int result = 0;
		pstmt = null;

		int age = vo.getAge();
		int ageid = 0;

		switch (age / 10) {
		case 1:
			ageid = 1;
			break;
		case 2:
			ageid = 2;
			break;
		case 3:
			ageid = 3;
			break;
		case 4:
			ageid = 4;
			break;
		case 5:
			ageid = 5;
			break;
		case 6:
			ageid = 6;
			break;
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPasswd());
			pstmt.setString(2, vo.getEmail());
			pstmt.setInt(3, vo.getLocnum());
			pstmt.setString(4, vo.getPhone());
			pstmt.setInt(5, age);
			pstmt.setInt(6, ageid);
			pstmt.setString(7, vo.getId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("업데이트 SQL에서 문제가 생겼어요");
		} finally {
			close();
		}
		return result;
	}
	
	// 아이디 중복확인
	public int duplecateID(Connection conn, String id) {

		int cnt = 0;

		try {
			StringBuilder sql = new StringBuilder();
			// 아이디 중복 확인
			sql.append(" SELECT count(id) as cnt ");
			sql.append(" FROM member ");
			sql.append(" WHERE id = ? ");

			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}
		} catch (Exception e) {
			System.out.println("아이디 중복 확인 실패 : " + e);
		}
		return cnt;
	}

	// 이메일 중복확인
	public int duplecateEmail(Connection conn, String email) {

		int cnt = 0;

		try {
			StringBuilder sql = new StringBuilder();
			// 아이디 중복 확인
			sql.append(" SELECT count(email) as cnt ");
			sql.append(" FROM member ");
			sql.append(" WHERE email = ? ");

			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, email);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}
		} catch (Exception e) {
			System.out.println("이메일 중복 확인 실패 : " + e);
		}
		return cnt;
	}

		public ArrayList<Board> myboardRead(Connection conn, Board vo, String id, int hobbyId, Date bdate) {

		ArrayList<Board> list = null;
		String sql = "select * from board where id = ?";

		/*
		 * if (search == null) { sql += " order by id"; } else { sql +=
		 * " where id like '%" + search + "%' order by i"; }
		 */
		Board ResultVO = new Board();
		pstmt = null;
		rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				list = new ArrayList<Board>();
				do {

					ResultVO.setBsubject(rs.getString("bsubject"));
					ResultVO.setId(rs.getString("id"));
					ResultVO.setHobbyId(rs.getInt("hobbyId"));
					ResultVO.setBcontent(rs.getString("bcontent"));
					ResultVO.setBdate(rs.getDate("bdate"));

					list.add(ResultVO);
				} while (rs.next());
			}
			System.out.println("list : " + list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	public ArrayList<Board> myboardlist(Connection conn, String search, int hobbyId, Date bdate, String bsubject,
			String bcontent) {
		ArrayList<Board> list = null;
		String sql = "select * from board ";

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
				list = new ArrayList<Board>();
				do {
					Board ResultVO = new Board();
					ResultVO.setHobbyId(rs.getInt("hobbyId"));
					ResultVO.setBsubject(rs.getString("bsubject"));
					ResultVO.setBcontent(rs.getString("bcontent"));
					ResultVO.setBdate(rs.getDate("bdate"));

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