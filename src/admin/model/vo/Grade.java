package admin.model.vo;

public class Grade {
	String id;
	String name;
	int mpoint;
	int gradeId;
	String gradeName;
	
	public Grade() {}

	public Grade(String id, String name, int mpoint, int gradeId, String gradeName) {
		super();
		this.id = id;
		this.name = name;
		this.mpoint = mpoint;
		this.gradeId = gradeId;
		this.gradeName = gradeName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMpoint() {
		return mpoint;
	}

	public void setMpoint(int mpoint) {
		this.mpoint = mpoint;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	@Override
	public String toString() {
		return "Grade [id=" + id + ", name=" + name + ", mpoint=" + mpoint + ", gradeId=" + gradeId + ", gradeName="
				+ gradeName + "]";
	}
	
	
}
