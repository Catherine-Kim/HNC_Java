package kosta.edu.model;

public class KostaDAOImpl implements KostaDAO{
	// field 
	private Student st;
	private String DataSource;
	private String location;
	
	@Override
	public void register() {
		System.out.println(st.name + " 님이 등록되었습니다.");
	}

	@Override
	public String pringMsg() {
		return DataSource + ", " + location;
	}

	public void setDataSource(String dataSource) {
		DataSource = dataSource;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDataSource() {
		return DataSource;
	}

	public String getLocation() {
		return location;
	}

	public Student getSt() {
		return st;
	}

	public void setSt(Student st) {
		this.st = st;
	}

	@Override
	public String toString() {
		return "KostaDAOImpl [st=" + st + ", DataSource=" + DataSource + ", location=" + location + "]";
	}
	
	
}
