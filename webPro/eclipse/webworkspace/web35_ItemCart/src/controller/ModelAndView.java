package controller;

public class ModelAndView {
	private String url;
	private boolean isRedirect;
	
	// 생성자 안 쓰고 setter 써서 값 주입할 거얌
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
}
