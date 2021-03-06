package spring.service.user.impl;

import java.util.List;

import spring.service.domain.User;
import spring.service.user.UserDao;
import spring.service.user.UserService;

// SpringUserServiceImpl07 + SpringUserDaoImpl06

public class SpringUserServiceImpl07 implements UserService{
	// field
	private UserDao userDao;

	// setter
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public int addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

	@Override
	public User getUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getUser(userId);
	}

	@Override
	public int updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	@Override
	public List<User> getUserList(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getUserList();
	}
}
