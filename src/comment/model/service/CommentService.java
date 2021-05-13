package comment.model.service;

import comment.model.dao.CommentDao;
import comment.model.vo.Comment;
import static common.JDBCPool.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CommentService {

	public int addComment(Comment commentVO) throws SQLException {
		int result = 0;
		Connection conn = getConnection();
		result = new CommentDao().addComment(conn, commentVO);
			if (result != 0) {
				commit(conn);
			}
		close(conn);
		return result;
	}

	public List<Comment> commentVOList(Comment commentVO) throws SQLException{
		List<Comment> CommentVOList = null;
		Connection conn = getConnection();
		CommentVOList = new CommentDao().commentVOList(conn, commentVO);
		close(conn);
		return CommentVOList;
	}
	
	public int modComment(Comment commentVO) throws SQLException {
		int result = 0;
		Connection conn = getConnection();
		result = new CommentDao().modComment(conn, commentVO);
			if (result != 0) {
				commit(conn);
			}
		close(conn);
		return result;
	}
	
	public Comment readComment(Comment commentVO) throws SQLException{
		Comment resultVO = null;
		Connection conn = getConnection();
		resultVO = new CommentDao().readComment(conn, commentVO);
		close(conn);
		return resultVO;
	}
	
	public int deleteComment(Comment commentVO) throws SQLException {
	      int result = 0;
	      Connection conn = getConnection();
	      result = new CommentDao().deleteComment(conn, commentVO);
	         if (result != 0) {
	            commit(conn);
	         }
	      close(conn);
	      return result;
	   }
}
