package exception.self.test;

class DuplicateNameException extends Exception{ 
	DuplicateNameException(){				
		this("(이)라는 이름이 이미 있다능"); 
	}
	
	DuplicateNameException(String m){
		super(m);
	}
}

class MemberArray{
	public static void printMember(String name) throws DuplicateNameException{ // ????? 왜 입력값이 str인데 name이 인자값인 메소드로 들어가냐?? 
		String result = ""; // 4. ""문자열을 result에 저장한다
		String[ ] names = {"서현","티파니","수영","유리","제시카"}; // 5. String 배열에 {값들}
		for(String s : names){ // str이 입력된 배열들 중에 한 사람인지 찾음
			if(s.equals(name)){ // 만약에 입력한 값이 배열의 문자데이타와 같으면 
				System.out.print(name); // 데이터를 출력 
				throw new DuplicateNameException(); // ?????????
			}else{
				result += s + "\n"; 
			}
		}
		System.out.println(result + name);
	}
}

public class MemberArrayTest3 {
	public static void main(String[] args) { // 1.string[] args = 를 통해 값이 입력한 값이 들어온다.
		try{
			String str = args[0]; // 2.첫번째로 입력한 값을 str로 저장한다. 
			MemberArray.printMember(str); // 3.memberArray클레스에 printMember method에서 입력값을 찾는다.
		}catch(DuplicateNameException e){ 
			System.out.println(e.getMessage()); 
		}catch(ArrayIndexOutOfBoundsException e){ 
			System.out.println("입력값이 있어야 합니당");
		}
	}
}