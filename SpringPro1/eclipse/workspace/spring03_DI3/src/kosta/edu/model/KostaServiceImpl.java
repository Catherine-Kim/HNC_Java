package kosta.edu.model;

public class KostaServiceImpl implements KostaService{
	// field
	private int num;
	private Integer birthDate;
	private String name;
	
	// num, birthDate는 setter로, name은 생성자로 주입
	public KostaServiceImpl(String name) {
		super();
		this.name = name;
	}

	public void setBirthDate(Integer birthDate) {
		this.birthDate = birthDate;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String message() {
		return "num :: " + num + ", birthDate :: " + birthDate + ", name :: " + name;
	}
}
