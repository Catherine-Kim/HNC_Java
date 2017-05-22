package controller;
/*
 * 서버상에서 페이지의 이동방식과 경로를 지정하는 객체
 */
public class ModelAndView {
	private String path;
	private boolean isRedirect;
	
	public ModelAndView(String path, boolean isRedirect) {
		super();
		this.path = path;
		this.isRedirect = isRedirect;
	}
	public ModelAndView() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ModelAndView(String path) {
		super();
		this.path = path;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
}
















