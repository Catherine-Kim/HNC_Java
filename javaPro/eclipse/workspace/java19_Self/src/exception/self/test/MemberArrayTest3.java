package exception.self.test;

class DuplicateNameException extends Exception{ 
	DuplicateNameException(){				
		this("(��)��� �̸��� �̹� �ִٴ�"); 
	}
	
	DuplicateNameException(String m){
		super(m);
	}
}

class MemberArray{
	public static void printMember(String name) throws DuplicateNameException{ // ????? �� �Է°��� str�ε� name�� ���ڰ��� �޼ҵ�� ����?? 
		String result = ""; // 4. ""���ڿ��� result�� �����Ѵ�
		String[ ] names = {"����","Ƽ�Ĵ�","����","����","����ī"}; // 5. String �迭�� {����}
		for(String s : names){ // str�� �Էµ� �迭�� �߿� �� ������� ã��
			if(s.equals(name)){ // ���࿡ �Է��� ���� �迭�� ���ڵ���Ÿ�� ������ 
				System.out.print(name); // �����͸� ��� 
				throw new DuplicateNameException(); // ?????????
			}else{
				result += s + "\n"; 
			}
		}
		System.out.println(result + name);
	}
}

public class MemberArrayTest3 {
	public static void main(String[] args) { // 1.string[] args = �� ���� ���� �Է��� ���� ���´�.
		try{
			String str = args[0]; // 2.ù��°�� �Է��� ���� str�� �����Ѵ�. 
			MemberArray.printMember(str); // 3.memberArrayŬ������ printMember method���� �Է°��� ã�´�.
		}catch(DuplicateNameException e){ 
			System.out.println(e.getMessage()); 
		}catch(ArrayIndexOutOfBoundsException e){ 
			System.out.println("�Է°��� �־�� �մϴ�");
		}
	}
}