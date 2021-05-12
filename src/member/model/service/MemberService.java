package member.model.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import board.model.dao.BoardDao;
import board.model.vo.Board;
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

	// 멤버 포인트 조회
	public ArrayList<Member> memberPoint(String search) {
		ArrayList<Member> list = null;
		Connection conn = getConnection();
		try {
			list = new MemberDao().memberPoint(conn, search);
		} catch (Exception e) {
			e.printStackTrace();
		}
		close(conn);
		return list;
	}

	// 멤버 등급 업
	public int gradeUp(Member vo, String id, int mpoint) {
		int result = 0;
		Connection conn = getConnection();
		try {
			result = new MemberDao().gradeUp(conn, vo, id, mpoint);
			if (result != 0) {
				commit(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return result;
	}

	public int getMemberCount(String search) {
		Connection conn = getConnection();
		int result = new MemberDao().getMemberCount(conn, search);
		close(conn);
		return result;
	}

	public List<Member> getMemberByPage(int start, int end, String search) {
		Connection conn = getConnection();
		List<Member> list = new MemberDao().getMemberByPage(conn, start, end, search);
		close(conn);
		return list;
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

	// 회원관리
	public ArrayList<Member> memberUser(String search) {
		ArrayList<Member> list = null;
		Connection conn = getConnection();
		try {
			list = new MemberDao().memberUser(conn, search);
		} catch (Exception e) {
			e.printStackTrace();
		}
		close(conn);
		return list;
	}

	// 회원탈퇴

	public int memberDelete(Member vo, String id, int phone) {
		int result = 0;
		Connection conn = getConnection();
		try {
			result = new MemberDao().memberDelete(conn, vo, id, phone);

			if (result != 0) {
				commit(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return result;
	}

}