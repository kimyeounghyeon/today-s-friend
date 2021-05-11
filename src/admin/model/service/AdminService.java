package admin.model.service;

import static common.JDBCPool.*;

import java.sql.Connection;
import java.util.List;

import admin.model.dao.AdminDao;
import admin.model.vo.Admin;

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
}