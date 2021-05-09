package member.model.service;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import member.model.dao.MemberDao;
import member.model.vo.Member;

import static common.JDBCPool.*;

public class MemberService {

	// insert()
	public int insert(Member vo) {
		int result = 0;
		Connection conn = getConnection();
		try {
			result = new MemberDao().insert(conn, vo);
			if(result!=0) {
				commit(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close(conn);
		return result;
	}
	
	// login()
		public Member loginAndReadMember(Member vo) {
			Member result = null;
			Connection conn = getConnection();
			try {
				result = new MemberDao().loginAndReadMember(conn, vo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			close(conn);
			return result;
		}
}