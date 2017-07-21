package product.service.aop.vo;

public class ReportVO {
	// field
	private String word;
	private int cnt;
	private int ranking;
	
	public ReportVO() {	}
	
	public ReportVO(String word, int cnt, int ranking) {
		super();
		this.word = word;
		this.cnt = cnt;
		this.ranking = ranking;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
}
