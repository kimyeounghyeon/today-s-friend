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
}
