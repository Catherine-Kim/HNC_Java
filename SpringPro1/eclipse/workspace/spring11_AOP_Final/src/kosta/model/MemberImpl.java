package kosta.model;

public class MemberImpl implements Member{
	@Override
	public void deleteMember(String id, String name) {
		System.out.println("[SUCCESS] deleteMember - id : " + id + ", name : " + name);		
	}
}
