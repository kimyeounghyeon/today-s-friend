package board.model.vo;

import java.sql.Date;

public class AdminBoard {
	private int admno;
	private String admsubject;
	private String admcontent;
	private Date admdate;
	private String id;
	
	public AdminBoard(int admno, String admsubject, String admcontent, Date admdate, String id) {
		super();
		this.admno = admno;
		this.admsubject = admsubject;
		this.admcontent = admcontent;
		this.admdate = admdate;
		this.id = id;
	}
	public AdminBoard() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getAdmno() {
		return admno;
	}
	public void setAdmno(int admno) {
		this.admno = admno;
	}
	public String getAdmsubject() {
		return admsubject;
	}
	public void setAdmsubject(String admsubject) {
		this.admsubject = admsubject;
	}
	public String getAdmcontent() {
		return admcontent;
	}
	public void setAdmcontent(String admcontent) {
		this.admcontent = admcontent;
	}
	public Date getAdmdate() {
		return admdate;
	}
	public void setAdmdate(Date admdate) {
		this.admdate = admdate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
	

}
