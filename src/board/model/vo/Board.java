package board.model.vo;

import java.sql.Date;

public class Board {
	
	private int fbno; // 페이크 번호
	private int bno;
	private String bsubject;
	private String bcontent;
	private Date bdate;
	private String id;
	private String bfilePath;
	private int locNum;
	private int hobbyId;
	
	public Board() {}
	
	public Board(int fbno, int bno, String bsubject, String bcontent, Date bdate, String id, String bfilePath, int locNum,
			int hobbyId) {
		super();
		this.fbno = fbno;
		this.bno = bno;
		this.bsubject = bsubject;
		this.bcontent = bcontent;
		this.bdate = bdate;
		this.id = id;
		this.bfilePath = bfilePath;
		this.locNum = locNum;
		this.hobbyId = hobbyId;
	}

	@Override
	public String toString() {
		return "Board [fbno=" + fbno + ", bno=" + bno + ", bsubject=" + bsubject + ", bcontent=" + bcontent + ", bdate=" + bdate + ", id="
				+ id + ", bfilePath=" + bfilePath + ", locNum=" + locNum + ", hobbyId=" + hobbyId + "]";
	}
	
	public int getFbno() {
		return fbno;
	}

	public void setFbno(int fbno) {
		this.fbno = fbno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBsubject() {
		return bsubject;
	}

	public void setBsubject(String bsubject) {
		this.bsubject = bsubject;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBfilePath() {
		return bfilePath;
	}

	public void setBfilePath(String bfilePath) {
		this.bfilePath = bfilePath;
	}

	public int getLocNum() {
		return locNum;
	}

	public void setLocNum(int locNum) {
		this.locNum = locNum;
	}

	public int getHobbyId() {
		return hobbyId;
	}

	public void setHobbyId(int hobbyId) {
		this.hobbyId = hobbyId;
	}
	
}
