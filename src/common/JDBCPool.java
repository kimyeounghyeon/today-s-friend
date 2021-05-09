package common;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JDBCPool {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Context i1 = new InitialContext(); // List<String> l1 = new ArrayList<String>();처럼
			// 앞에는 인터페이스 뒤에는 클래스, 해당 변수의 타입의 메소드를 깔끔하게 사용 가능
			Context i2 = (Context) i1.lookup("java:/comp/env"); // web.xml로 가서 찾아주세요.(lookup)
			DataSource ds = (DataSource) i2.lookup("jdbc/semi5");
			conn = ds.getConnection();
			if (conn == null) {
				System.out.println("**연결실패**");
			} else {
				System.out.println("!!!!!!연결 성공!!!!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
