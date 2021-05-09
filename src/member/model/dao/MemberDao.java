package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import member.model.vo.Member;

public class MemberDao {
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
		String passwd = vo.getPasswd();
		
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		
		pstmt = null;
		rs = null;
		Member resultVO = new Member();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
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
			}else {
				System.out.println("아이디 확인 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return resultVO;
	}
	
	public ArrayList<Member> memberPoint (Connection conn, String search) {
		ArrayList<Member> list = null;
		String sql = "select * from member ";
		
		if(search == null) {
			sql += " order by mpoint";
		} else {
			sql += " where id like '%" + search + "%' order by mpoint";
		}
		
		
		pstmt = null;
		rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				list = new ArrayList<Member>();
				do {
					Member ResultVO = new Member();
					
					ResultVO.setId(rs.getString("id"));
					ResultVO.setPasswd(rs.getString("passwd"));
					ResultVO.setName(rs.getString("name"));
					ResultVO.setEmail(rs.getString("email"));
					ResultVO.setGender(rs.getString("gender").charAt(0));
					ResultVO.setLocnum(rs.getInt("locnum"));
					ResultVO.setPhone(rs.getString("phone"));
					ResultVO.setAge(rs.getInt("age"));

					list.add(ResultVO);
				}while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
}
