package test;

import step2.src.UserDAO;
import step2.src.UserDAOImpl;

public class UserDAOTest2 {
	public static void main(String[] args) {
		UserDAO dao = new UserDAOImpl();
		dao.register("±è¿ìÁ¤");
	}
}
