package member.model.service;

import java.sql.*;
import java.util.ArrayList;

import board.model.dao.BoardDao;
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
		
		// 멤버 포인트 조회
		public ArrayList<Member> memberPoint(String search){
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
		
		// 회원관리
	      public ArrayList<Member> memberUser(String search){
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
		
		
		// 멤버 등급 업
		public int gradeUp(Member vo) {
			int result = 0;
			Connection conn = getConnection();
			try {
			result = new MemberDao().gradeUp(conn, vo);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(conn);
			}
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
		
//		public int getMemberCount(String search) {
//			Connection conn = getConnection();
//			int cnt = new MemberDao().getMemberCount(conn, search);
//			close(conn);
//			return cnt;
//		}
		
		
}