package admin.model.vo;

import java.sql.Timestamp;

public class Admin {

	private int admno;
	private String admsubject;
	private String admcontent;
	private Timestamp admdate;
	private String id;
	private String admfilepath;
	
	public Admin() {}
	
	public Admin(int admno, String admsubject, String admcontent, Timestamp admdate, String id, String admfilepath) {
		super();
		this.admno = admno;
		this.admsubject = admsubject;
		this.admcontent = admcontent;
		this.admdate = admdate;
		this.id = id;
		this.admfilepath = admfilepath;
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

	public Timestamp getAdmdate() {
		return admdate;
	}

	public void setAdmdate(Timestamp admdate) {
		this.admdate = admdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAdmfilepath() {
		return admfilepath;
	}

	public void setAdmfilepath(String admfilepath) {
		this.admfilepath = admfilepath;
	}
	
}
