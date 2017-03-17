package access.child;

import access.parent.Parent;

public class Child extends Parent{
	public void test(){
		System.out.println(publicField);
		System.out.println(protectedField);
	}
	
	@Override
	public void access() {
		super.access();
		System.out.println("��ӹ��� �ʵ�� " + publicField);
		System.out.println("��ӹ��� �ʵ�� " + protectedField);
	}
}
