package spring.service.user.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import spring.service.domain.User;
import spring.service.user.UserDao;
import spring.service.user.UserService;

// SpringUserServiceImpl07 + SpringUserDaoImpl06

@Component
public class SpringUserServiceImpl08 implements UserService{
	// field
	@Resource
	private UserDao userDao;

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
