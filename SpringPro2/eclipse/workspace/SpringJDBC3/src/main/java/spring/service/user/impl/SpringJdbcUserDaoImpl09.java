package spring.service.user.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import spring.service.domain.User;
import spring.service.user.SqlService;
import spring.service.user.UserDao;


public class SpringJdbcUserDaoImpl09 extends JdbcDaoSupport implements UserDao{
	// field �߰�
	@Inject
	@Named("sqlService")
	private SqlService sqlService;

	// constructor �߰�
	public SpringJdbcUserDaoImpl09() {
		System.out.println(":: " + getClass().getName() + "() Default Constructor");
	}

	///Method
	//==> ȸ������ ::  INSERT ( ȸ������ )
	public int addUser(User user)  throws Exception{		
		// �������� ���ε��� ������ ���� Object �迭
		Object[] args = new Object[]{
				user.getUserId(),
				user.getUserName(),
				user.getPassword(),
				user.getAge(),
				user.getRegDate()
		};
		
		return getJdbcTemplate().update(sqlService.getSql("user.sql.insert"), args);
	}	
	
			
	//==> ȸ������ ::  SELECT  ( ȸ������ �˻� ) 
	public User getUser(String userId) throws Exception {
		Object[] param = new Object[]{userId};
		
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		return getJdbcTemplate().queryForObject(sqlService.getSql("user.sql.select"), param, mapper);
	}//end of method

	
	//==> ȸ������ ::  UPDATE  ( ȸ������ ����  )
	public int updateUser(User user) throws Exception {
		Object[] args = {
			user.getUserName(),
			user.getPassword(),
			user.getAge(),
			user.getUserId()
		};
		
		return getJdbcTemplate().update(sqlService.getSql("user.sql.update"), args);
	}	
	
	//==> ȸ������ ::  DELETE  ( ȸ������ ���� )
	public int removeUser(String userId) throws Exception{		
		Object[] args = {userId};
		
		return getJdbcTemplate().update(sqlService.getSql("user.sql.delete").toString(),args);
		
	}//end of class
	
	
	//==> ȸ������ ::  SELECT  ( ��� ȸ�� ���� �˻� )
	public List<User> getUserList() throws Exception {
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		return getJdbcTemplate().query(sqlService.getSql("user.sql.selectAll"), mapper);
	}//end of Method
	
}//end of class

/*
 * ������ ::

 */




















