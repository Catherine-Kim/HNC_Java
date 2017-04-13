package servlet.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsingConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//field
	private int count;
	private String path;
	
    @Override
    public void init() throws ServletException {
    	System.out.println("init() method calling ... by Container");
    	
    	// 서버에서 path 가져오기
    	path = getInitParameter("path");                                                            
    	
    	// 서버가 다시 가동될 때 이 부분이 호출됨
    	// Path에 저장된 File의 값을 읽어와서 그 값을 콘솔로 출력
    	// 1) BufferedReader, FileReader Stream 생성
    	// 2) 읽어들인다
    	// 3) 읽어들인 count 값을 콘솔로 출력

		try {
			FileReader fr = new FileReader(new File(path));
			BufferedReader br = new BufferedReader(fr);
			
			String countStored = br.readLine();
			System.out.println("Count :: " + countStored);
			count = Integer.parseInt(countStored);
			
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }

    @Override
	public void destroy() {
    	System.out.println("destroy() method calling ... by Container");
    	
    	// 서버가 완전히 내려가기 전에 이 부분이 호출됨
        // 이 부분에서 증가된 count 값을 파일로 출력
        // 1) File 객체 생성
        // 2) getParentFile(), mkdirs() 사용해서
        // 3) PrintWriter, FileWriter 이용
        // 4) 마지막으로 File의 path와 File에 뿌려진 count 값을 콘솔로 출력
    
    	File file = new File(path);
    	boolean parentsMade = file.getParentFile().mkdirs();
    	System.out.println("1. Parents Directories Created :: " + parentsMade);
		
    	try {
    		boolean fileMade = file.createNewFile();
    		System.out.println("2. File Created :: " + fileMade);
		} catch (IOException e) {
			e.printStackTrace();
		}    	

		try {
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);
			
			pw.write(String.valueOf(count));
			
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
												throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		System.out.println("doGet() method calling ... by Container");
		
		out.println("<html><body bgcolor='orange'>");
		out.println("<h2>Count :: </h2>" + ++count + "<br/>");
		out.println("</body></html>");
	}
}
