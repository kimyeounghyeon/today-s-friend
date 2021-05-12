package comment.model.dao;

import java.sql.*;
import java.util.*;

import javax.naming.*;
import javax.sql.DataSource;

import comment.model.vo.Comment;

public class CommentDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private void close() {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Comment> commentVOList(Connection conn, Comment commentVO) throws SQLException {
        List<Comment> CommentVOList = null;
        Comment vo = null;

        try {
            String sql = " SELECT RENO, RECONTENT, ID, TO_CHAR(REDATE, 'yyyy-mm-dd hh24:mi:ss') AS redate "
                    + " FROM BOARDRE WHERE BNO = ? ORDER BY RENO DESC ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, commentVO.getBno());
            rs = pstmt.executeQuery();

            CommentVOList = new ArrayList<Comment>();
            while (rs.next()) {
                vo = new Comment();
                vo.setReno(rs.getInt("reno"));
                vo.setRecontent(rs.getString("recontent"));
                vo.setId(rs.getString("id"));
                vo.setRedate(rs.getString("redate"));
                CommentVOList.add(vo);
            }
        } finally {
            close();
        }
        return CommentVOList;
    }

	public int addComment(Connection conn, Comment commentVO) throws SQLException {
		int result = 0;

		try {
			String sql = " INSERT INTO BOARDRE" 
			+ " VALUES(SEQ_COMMENTS.NEXTVAL, ?, ?, DEFAULT, ?) ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, commentVO.getRecontent());
			pstmt.setString(2, commentVO.getId());
			pstmt.setInt(3, commentVO.getBno());
			result = pstmt.executeUpdate();

		} finally {
			close();
		}
		return result;
	}

}