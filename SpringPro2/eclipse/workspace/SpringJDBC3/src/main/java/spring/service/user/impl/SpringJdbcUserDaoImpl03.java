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

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import spring.service.domain.User;
import spring.service.user.UserDao;

public class SpringJdbcUserDaoImpl03 extends JdbcDaoSupport implements UserDao{
	
	// constructor �߰�
	public SpringJdbcUserDaoImpl03() {
		System.out.println(":: " + getClass().getName() + "() Default Constructor");
	}

	///Method
	//==> ȸ������ ::  INSERT ( ȸ������ )
	public int addUser(User user)  throws Exception{
		// �������� ����� �� �ֱ� ������ StringBuffer ���
		StringBuffer userInsert = new StringBuffer();
		
		// ������
		userInsert.append("INSERT INTO users ");
		userInsert.append("(user_id, user_name, password, age) ");
		userInsert.append("VALUES(?, ?, ?, ?)");
		
		
		// �������� ���ε��� ������ ���� Object �迭
		Object[] args = new Object[]{
				user.getUserId(),
				user.getUserName(),
				user.getPassword(),
				user.getAge(),
		};
		
		return getJdbcTemplate().update(userInsert.toString(), args);
	}	
	
			
	//==> ȸ������ ::  SELECT  ( ȸ������ �˻� ) 
	public User getUser(String userId) throws Exception {
		StringBuffer userSelect = new StringBuffer();
		Object[] param = new Object[]{userId};
		
		userSelect.append("SELECT user_id, user_name, age, reg_date ");
		userSelect.append("FROM users ");
		userSelect.append("WHERE user_id = ?");
		
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		return getJdbcTemplate().queryForObject(userSelect.toString(), param, mapper);
	}//end of method

	
	//==> ȸ������ ::  UPDATE  ( ȸ������ ����  )
	public int updateUser(User user) throws Exception {
		StringBuffer userUpdate = new StringBuffer();
		userUpdate.append("UPDATE users ");
		userUpdate.append("SET user_name = ?,password=?,age=? ");
		//userUpdate.append("SET user_name =:name,password=:password,age=:age ");
		userUpdate.append("WHERE user_id=?");
		//userUpdate.append("WHERE user_id=:id");
		
		Object[] args = {
			user.getUserName(),
			user.getPassword(),
			user.getAge(),
			user.getUserId()
		};
		
		return getJdbcTemplate().update(userUpdate.toString(), args);
		
	}	
	
	//==> ȸ������ ::  DELETE  ( ȸ������ ���� )
	public int removeUser(String userId) throws Exception{
		StringBuffer  userDelete = new StringBuffer();
		userDelete.append("DELETE ");
		userDelete.append("FROM USERS ");
		userDelete.append("WHERE user_id=?");
		
		Object[] args = {userId};
		
		return getJdbcTemplate().update(userDelete.toString(),args);
		
	}//end of class
	
	
	//==> ȸ������ ::  SELECT  ( ��� ȸ�� ���� �˻� )
	public List<User> getUserList() throws Exception {
		StringBuffer userSelectList = new StringBuffer();
		
		userSelectList.append("SELECT user_id, user_name, age, reg_date ");
		userSelectList.append("FROM users");
		
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		return getJdbcTemplate().query(userSelectList.toString(), mapper);
	}//end of Method
	
}//end of class

/*
 * ������ ::

 */




















