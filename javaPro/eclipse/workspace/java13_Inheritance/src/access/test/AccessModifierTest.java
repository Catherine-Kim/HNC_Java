package access.test;

import access.child.Child;

public class AccessModifierTest {
	public static void main(String[] args) {
		Child cc = new Child();
		cc.test();
		
		System.out.println("\n--------------------------------------------");
		cc.access();
	}
}
