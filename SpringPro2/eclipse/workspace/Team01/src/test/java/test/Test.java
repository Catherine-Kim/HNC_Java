package test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import persistence.User;
import persistence.UserDao;
import service.UserService;

/*
 * FileName : SpringJdbcUserDaoTestApp07.java
 */
public class Test {
	///Main Method
	public static void main(String[] args) throws Exception{

		ApplicationContext context =
				new ClassPathXmlApplicationContext(
				new String[] {	"/config/datasourceservice.xml",
								"/config/userservice.xml"	 }
									                                                    );
		//==> IoC Container �� ���� ȹ���� UserDAO �ν��Ͻ� ȹ��
		UserService userService 
							= (UserService)context.getBean("userService");
		
		User user = new User("user04","�ָ�","user04",40);

		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//1.UserService.addUser(user) Test
		System.out.println(":: 1. add(INSERT)  ? " + userService.addUser(user));
		
		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//2.UserService.getUser(userId) Test
		User user1 = userService.getUser("user04");
		System.out.println(":: 2. get(SELECT)  ? "+user1);
		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//3.UserService.uadateUser(user) Test
		user.setUserName("�庸��");
		System.out.println(":: 3. update(UPDATE)  ? ");
		userService.updateUser(user);
		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//4.UserService.getUser(userId) Test
		user = userService.getUser("user04");
		System.out.println(":: 4. get(SELECT)  ? "+user);

		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//5.UserDAO.removeUser(userId) Test
		//==> UserService ���� removeUser�� �����Ƿ�, DAO���� ���� ȣ�� Test
		UserDao userDAO   = (UserDao)context.getBean("userDao");
		
		System.out.println(":: 5. remove(DELETE)  ? "+userDAO.removeUser("user04"));
		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//6.UserService.getUserList() Test
		System.out.println(":: 6. all User(SELECT)  ? ");
		List<User> list = userService.getUserList();
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.print( "<"+ ( i +1 )+"> ��° ȸ�� ����... ");
			System.out.println( list.get(i).toString() );
		}
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	}
}//end of class