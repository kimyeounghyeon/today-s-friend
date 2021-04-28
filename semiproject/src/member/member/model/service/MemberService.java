package member.member.model.service;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static member.common.JDBCTemplate.*;
import member.member.model.dao.MemberDao;
import member.member.model.vo.Member;

public class MemberService {

	// selectAll()
	public ArrayList<Member> selectAll() {
		Connection conn = null;
		conn = getConnection();
		ArrayList<Member> list = new MemberDao().selectAll(conn);
		close(conn);
		return list;
	}

	public ArrayList<Member> selectSearch(String col, String str) {
		Connection conn = getConnection();
		ArrayList<Member> list = new MemberDao().selectSearch(conn, col, str);
		close(conn);
		return list;
	}

	// insert()
	public int insert(Member vo) {
		int result = 0;
		int result2 = 0;
		Connection conn = getConnection();
		try {

			result = new MemberDao().insert(conn, vo);

		} catch (Exception e) {
			e.printStackTrace();
		}

		close(conn);
		return result;
	}

	// update()
	public int update(String col, Member vo) {
		int result = 0;
		Connection conn = getConnection();

		result = new MemberDao().update(conn, col, vo);
		close(conn);
		return result;
	}

	// delete()
	public int delete(String col, String str) {
		int result = 0;
		Connection conn = getConnection();
		result = new MemberDao().delete(conn, col, str);
		close(conn);
		return result;
	}

	// login()
	public Member login(Member vo) {
		Member result = null;
		Connection conn = getConnection();
		result = new MemberDao().login(conn, vo);
		close(conn);
		return result;
	}
}
