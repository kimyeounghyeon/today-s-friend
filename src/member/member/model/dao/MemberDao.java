package member.member.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import member.common.JDBCTemplate;
import member.member.model.vo.Member;

public class MemberDao {
	// insert()
	public int insert(Connection conn, Member vo) {
		int result = 0;		
		
		String sql = "insert into member values(?,?,?,?,?,?,sysdate,?,?,null,default,default,default)";
		PreparedStatement pstmt = null;

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

			JDBCTemplate.close(pstmt);
		}

		return result;
	}
	
	public Member loginAndReadMember(Connection conn, Member vo) {
		String id = vo.getId();
		String passwd = vo.getPasswd();
		
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
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
				System.out.println("아이디 확인 성공");
			}else {
				System.out.println("아이디 확인 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return resultVO;
	}
	
}