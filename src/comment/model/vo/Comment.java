package comment.model.vo;

public class Comment {

	private int reno;
	private String recontent;
	private String id;
	private String redate;
	private int bno;

	public Comment() {
		super();
	}

	public Comment(int reno, String recontent, String id, String redate, int bno) {
		super();
		this.reno = reno;
		this.recontent = recontent;
		this.id = id;
		this.redate = redate;
		this.bno = bno;
	}

	public int getReno() {
		return reno;
	}

	public void setReno(int reno) {
		this.reno = reno;
	}

	public String getRecontent() {
		return recontent;
	}

	public void setRecontent(String recontent) {
		this.recontent = recontent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRedate() {
		return redate;
	}

	public void setRedate(String redate) {
		this.redate = redate;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

}