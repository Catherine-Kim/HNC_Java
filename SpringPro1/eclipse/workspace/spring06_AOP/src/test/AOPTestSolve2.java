package test;

import org.springframework.aop.framework.ProxyFactoryBean;

import solve.src.ProductService;
import solve.src.MemberService;
import solve.src.MemberServiceImpl;
import solve.src.ProductServiceImpl;
import solve.src.ServiceAdvice;

public class AOPTestSolve2 {
	public static void main(String[] args) {
		// mem, pro, advice라는 이름으로 각각 객체 생성
		MemberService mem = new MemberServiceImpl();
		ProductService pro = new ProductServiceImpl();
		ServiceAdvice advice = new ServiceAdvice();
		
		// AOP는 이전의 Container를 쓰지 않고 ProxyFactory라는 별도의 Container를 사용함
		ProxyFactoryBean proxyfactory = new ProxyFactoryBean();
		// 얘가 Target과 Advice를 짝짓고, Weaving 시켜주는 애
		// 얘는 그럼 Target과 Advice에 대한 정보를 모두 가지고 있어야 함
		
		proxyfactory.setTarget(mem);		// Target 등록
		proxyfactory.addAdvice(advice);		// Advice 등록
				
		// 이 부분 아주 중요
		MemberService pfMem = (MemberService) proxyfactory.getObject();
		//pfMem.register();
		pfMem.findMemberByID("kosta");
		/*System.out.println("-------------------------------------------");
		pro.deleteProduct("ajax");
		pro.updateProduct("ajax");*/
	}
}
