package ibatis.services.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibatis.services.domain.User;
import ibatis.services.user.UserDAO;
import ibatis.services.user.UserService;

@Service
public class MyBatisUserServiceImpl13 implements UserService{
	// field
	@Autowired
	private UserDAO userDAO;

	@Override
	public int addUser(User user) throws Exception {
		return userDAO.addUser(user);
	}

	@Override
	public int updateUser(User user) throws Exception {
		return userDAO.updateUser(user);
	}

	@Override
	public User getUser(String userId) throws Exception {
		return userDAO.getUser(userId);
	}

	@Override
	public List<User> getUserList(User user) throws Exception {
		return userDAO.getUserList(user);
	}
	
}
