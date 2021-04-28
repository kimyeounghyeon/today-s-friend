package member.member.model.vo;

import java.sql.Date;

public class Member {
	private static final long serialVersionUID = 1L;

	private String id;
	private String passwd;
	private String name;
	private String email;
	private char gender;
	private int locnum;
	private Date mdate;
	private int phone;
	private int age;
	private int ageid;
	private int Mpoint;
	private int gradeid;
	private int LEVnum;

	@Override
	public String toString() {
		return "Member [id=" + id + ", passwd=" + passwd + ", name=" + name + ", email=" + email + ", gender=" + gender
				+ ", locnum=" + locnum + ", mdate=" + mdate + ", phone=" + phone + ", age=" + age + ", ageid=" + ageid
				+ ", Mpoint=" + Mpoint + ", gradeid=" + gradeid + ", LEVnum=" + LEVnum + "]";
	}

	public Member(String id, String passwd, String name, String email, char gender, int locnum, Date mdate, int phone,
			int age, int ageid, int Mpoint, int gradeid, int LEVnum) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.locnum = locnum;
		this.mdate = mdate;
		this.phone = phone;
		this.age = age;
		this.ageid = ageid;
		this.Mpoint = Mpoint;
		this.gradeid = gradeid;
		this.LEVnum = LEVnum;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getLocnum() {
		return locnum;
	}

	public void setLocnum(int locnum) {
		this.locnum = locnum;
	}

	public Date getMdate() {
		return mdate;
	}

	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAgeid() {
		return ageid;
	}

	public void setAgeid(int ageid) {
		this.ageid = ageid;
	}

	public int getMpoint() {
		return Mpoint;
	}

	public void setMpoint(int mpoint) {
		Mpoint = mpoint;
	}

	public int getGradeid() {
		return gradeid;
	}

	public void setGradeid(int gradeid) {
		this.gradeid = gradeid;
	}

	public int getLEVnum() {
		return LEVnum;
	}

	public void setLEVnum(int lEVnum) {
		LEVnum = lEVnum;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Member() {
	}

}
