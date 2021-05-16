package member.model.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import admin.model.dao.AdminDao;
import board.model.dao.BoardDao;
import board.model.vo.Board;
import comment.model.dao.CommentDao;
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
			if (result != 0) {
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

	// search()
	public Member searchIdNPw(Member vo) {
		Member result = null;
		Connection conn = getConnection();
		try {
			result = new MemberDao().searchIdNPw(conn, vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		close(conn);
		return result;
	}

	public int memberupdate(Member vo) {
		Connection conn = getConnection();
		int result = 0;

		try {
			result = new MemberDao().updateMember(conn, vo);
			if (result != 0) {
				commit(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close(conn);
		return result;
	}

	public int duplecateID(String id) {
		int cnt = 0;
		Connection conn = getConnection();
		try {
			cnt = new MemberDao().duplecateID(conn, id);

			if (cnt != 0) {
				commit(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return cnt;
	}

	public int duplecateEmail(String email) {
		int cnt = 0;
		Connection conn = getConnection();
		try {
			cnt = new MemberDao().duplecateEmail(conn, email);

			if (cnt != 0) {
				commit(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return cnt;
	}

	public List<Board> myBoardRead(Board vo, String str, int hobbyid, Date bdate) {
		Connection conn = getConnection();
		List<Board> list = new MemberDao().myboardRead(conn, vo, str, hobbyid, bdate);
		close(conn);
		return list;
	}

	public int memberdelete(Member vo) {
		Connection conn = getConnection();
		int result = 0;

		try {
			result = new MemberDao().memberDelete(conn, vo);
			if (result != 0) {
				commit(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close(conn);
		return result;
	}

	// update point
	   public int updateMPoint(Member vo, int mpoint) {
	      Connection conn = getConnection();
	      int result = 0;

	      try {
	         result = new MemberDao().updateMPoint(conn, vo, mpoint);
	         if (result != 0) {
	            commit(conn);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      close(conn);
	      return result;
	   }
}