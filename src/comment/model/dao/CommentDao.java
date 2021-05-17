package comment.model.dao;

import java.sql.*;
import java.util.*;

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

	// 글에서 댓글 보기
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
				vo.setBno(commentVO.getBno());
				CommentVOList.add(vo);
			}
		} finally {
			close();
		}
		return CommentVOList;
	}

	// 댓글 추가
	public int addComment(Connection conn, Comment commentVO) throws SQLException {
		int result = 0;

		try {
			String sql = " INSERT INTO BOARDRE" + " VALUES(SEQ_COMMENTS.NEXTVAL, ?, ?, DEFAULT, ?) ";

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

	// 댓글 수정
	public int modComment(Connection conn, Comment commentVO) {
		int result = 0;
		String sql = "UPDATE BOARDRE SET RECONTENT = ?, REDATE = DEFAULT WHERE RENO = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, commentVO.getRecontent());
			pstmt.setInt(2, commentVO.getReno());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}

	// 하나의 댓글 보기
	public Comment readComment(Connection conn, Comment commentVO) {

		String sql = "SELECT BNO, RENO, RECONTENT, ID, TO_CHAR(REDATE, 'yyyy-mm-dd hh24:mi:ss') AS redate FROM BOARDRE WHERE RENO = ?";
		pstmt = null;
		rs = null;
		Comment resultVO = new Comment();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, commentVO.getReno());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				resultVO.setReno(commentVO.getReno());
				resultVO.setBno(rs.getInt("bno"));
				resultVO.setRecontent(rs.getString("recontent"));
				resultVO.setId(rs.getString("id"));
				resultVO.setRedate(rs.getString("redate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return resultVO;
	}

	// 댓글 삭제
	public int deleteComment(Connection conn, Comment commentVO) {
		int result = 0;

		String sql = "DELETE BOARDRE WHERE RENO = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, commentVO.getReno());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}

	// 내가 글의 댓글 리스트
	public List<Comment> myReplylist(Connection conn, int startRnum, int endRnum, String id) {
		List<Comment> list = null;
		String sql_1 = "(SELECT BNO FROM BOARD WHERE ID = ?)B";

		String sql = "SELECT BNO, RENO, RECONTENT, ID, TO_CHAR(REDATE, 'yyyy-mm-dd hh24:mi:ss') AS redate FROM " 
		+ " (SELECT ROWNUM N, R.* FROM BOARDRE R," + sql_1 + " "
		+ "WHERE R.BNO IN B.BNO ORDER BY R.REDATE DESC) " + " WHERE N >= ? AND N <= ? ";

		pstmt = null;
		rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, startRnum);
			pstmt.setInt(3, endRnum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				list = new ArrayList<Comment>();
				do {
					Comment ResultVO = new Comment();
					ResultVO.setBno(rs.getInt("bno"));
					ResultVO.setId(rs.getString("id"));
					ResultVO.setRecontent(rs.getString("recontent"));
					ResultVO.setRedate(rs.getString("redate"));
					ResultVO.setReno(rs.getInt("reno"));

					list.add(ResultVO);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	// 내가 쓴 글 총 댓글 카운트
	public int getMyReplyCount(Connection conn, String id) {
		int cnt = 0;
		String sql = "SELECT COUNT(*) FROM BOARDRE R, (SELECT BNO FROM BOARD WHERE ID = ?)B WHERE R.BNO IN B.BNO ORDER BY R.REDATE DESC";

		pstmt = null;
		rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
}