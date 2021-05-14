package admin.model.service;

import static common.JDBCPool.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.model.dao.AdminDao;
import admin.model.vo.Admin;
import admin.model.vo.Grade;
import board.model.dao.BoardDao;
import board.model.vo.Board;
import member.model.dao.MemberDao;
import member.model.vo.Member;

public class AdminService {

	public int getAdminCount() {
		Connection conn = getConnection();
		int result = new AdminDao().getAdminCount(conn);
		close(conn);
		return result;
	}

	public List<Admin> getAdminByPage(int start, int end) {
		Connection conn = getConnection();
		List<Admin> list = new AdminDao().getAdminByPage(conn, start, end);
		close(conn);
		return list;
	}

	public Admin adminRead(Admin inputVo) {
		Connection conn = getConnection();
		Admin result = new AdminDao().adminRead(conn, inputVo);
		close(conn);
		return result;
	}

	public int adminupdate(Admin vo) {
		Connection conn = getConnection();
		int result = 0;

		try {
			result = new AdminDao().adminModify(conn, vo);
			if (result != 0) {
				commit(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close(conn);
		return result;
	}

	public int adminWrite(Admin vo) {
		int result = 0;
		Connection conn = getConnection();
		try {
			result = new AdminDao().adminWrite(conn, vo);
			if (result != 0) {
				commit(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		close(conn);
		return result;
	}

	public int adminDelete(Admin vo) {
		int result = 0;
		Connection conn = getConnection();
		try {
			result = new AdminDao().adminDelete(conn, vo);

			if (result != 0) {
				commit(conn);
			}
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
			list = new AdminDao().memberPoint(conn, search);
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
			result = new AdminDao().gradeUp(conn, vo, id, mpoint);
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
		int result = new AdminDao().getMemberCount(conn, search);
		close(conn);
		return result;
	}

	public int getGradeCount(String search) {
		Connection conn = getConnection();
		int result = new AdminDao().getGradeCount(conn, search);
		close(conn);
		return result;
	}


	public List<Member> getMemberByPage(int start, int end, String search) {
		Connection conn = getConnection();
		List<Member> list = new AdminDao().getMemberByPage(conn, start, end, search);
		close(conn);
		return list;
	}

	
	public List<Grade> getGradeByPage(int start, int end, String search) {
		Connection conn = getConnection();
		List<Grade> list = new AdminDao().getGradeByPage(conn, start, end, search);
		close(conn);
		return list;
	}

	// 회원탈퇴
	public int memberDelete(Member vo, String id, int phone) {
		int result = 0;
		Connection conn = getConnection();
		try {
			result = new AdminDao().memberDelete(conn, vo, id, phone);

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
	
	// 회원관리
		public ArrayList<Member> memberUser(String search) {
			ArrayList<Member> list = null;
			Connection conn = getConnection();
			try {
				list = new AdminDao().memberUser(conn, search);
			} catch (Exception e) {
				e.printStackTrace();
			}
			close(conn);
			return list;
		}
}