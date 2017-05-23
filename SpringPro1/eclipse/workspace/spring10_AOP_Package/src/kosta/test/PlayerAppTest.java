package kosta.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kosta.product.service.Player;

public class PlayerAppTest {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("package.xml");
		Player player1 = (Player) factory.getBean("tv");
		Player player2 = (Player) factory.getBean("video");
		Player player3 = (Player) factory.getBean("audio");
		
		player1.start(3);
		player2.stop();
		System.out.println(player3.pause());
	}
}
