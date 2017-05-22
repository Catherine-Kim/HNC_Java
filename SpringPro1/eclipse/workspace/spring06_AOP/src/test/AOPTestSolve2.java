package test;

import org.springframework.aop.framework.ProxyFactoryBean;

import solve.src.ProductService;
import solve.src.MemberService;
import solve.src.MemberServiceImpl;
import solve.src.ProductServiceImpl;
import solve.src.ServiceAdvice;

public class AOPTestSolve2 {
	public static void main(String[] args) {
		// mem, pro, advice��� �̸����� ���� ��ü ����
		MemberService mem = new MemberServiceImpl();
		ProductService pro = new ProductServiceImpl();
		ServiceAdvice advice = new ServiceAdvice();
		
		// AOP�� ������ Container�� ���� �ʰ� ProxyFactory��� ������ Container�� �����
		ProxyFactoryBean proxyfactory = new ProxyFactoryBean();
		// �갡 Target�� Advice�� ¦����, Weaving �����ִ� ��
		// ��� �׷� Target�� Advice�� ���� ������ ��� ������ �־�� ��
		
		proxyfactory.setTarget(mem);		// Target ���
		proxyfactory.addAdvice(advice);		// Advice ���
				
		// �� �κ� ���� �߿�
		MemberService pfMem = (MemberService) proxyfactory.getObject();
		//pfMem.register();
		pfMem.findMemberByID("kosta");
		/*System.out.println("-------------------------------------------");
		pro.deleteProduct("ajax");
		pro.updateProduct("ajax");*/
	}
}
