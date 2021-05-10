package board.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import board.model.vo.AdminBoard;
import board.model.vo.Board;

public class AdminBoardDao {
	
	//1.공지사항 값 전부 가져오는 쿼리
	//2.공지사항 insert
	//3.공지사항 modify
	//4  공지사항 delete
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	Connection conn;
	
	public Connection getConn() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "semi5";
		String password = "semi5";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getConn() Exception!!!");
		}
		return conn;
	} 
	
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
	
	
	public int insert(AdminBoard vo) {
		int result = 0;
		int max = 1;
		// 원글
		String sql = "INSERT INTO ADMINBOARD(admno,admsubject,admcontent,admdate,id) VALUES(adminboard_seq.nextval, ?, ?, " 
				+ " DEFAULT, ?)";

		pstmt = null;
		rs = null;

		try {
			// 글 작성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getAdmsubject());
			pstmt.setString(2, vo.getAdmcontent());
			pstmt.setString(3, vo.getId());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            close();
		}

		return result;
	}



}
