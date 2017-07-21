package spring.service.user.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import spring.service.domain.User;
import spring.service.user.UserDao;
import spring.service.user.UserService;

// SpringUserServiceImpl07 + SpringUserDaoImpl06

@Service
public class SpringUserServiceImpl09 implements UserService{
	// field
	@Inject
	@Named("springJdbcUserDaoImpl09")
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
