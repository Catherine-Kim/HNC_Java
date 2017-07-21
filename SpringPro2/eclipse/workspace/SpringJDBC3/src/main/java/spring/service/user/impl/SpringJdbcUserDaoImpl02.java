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

import spring.service.domain.User;
import spring.service.user.UserDao;

public class SpringJdbcUserDaoImpl02 implements UserDao{
	// field �߰�
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	// setter, getter �߰�
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	
	// constructor �߰�
	public SpringJdbcUserDaoImpl02() {
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
		
		return jdbcTemplate.update(userInsert.toString(), args);
	}	
	
			
	//==> ȸ������ ::  SELECT  ( ȸ������ �˻� ) 
	public User getUser(String userId) throws Exception {
		StringBuffer userSelect = new StringBuffer();
		Object[] param = new Object[]{userId};
		
		userSelect.append("SELECT user_id, user_name, age, reg_date ");
		userSelect.append("FROM users ");
		userSelect.append("WHERE user_id = ?");
		
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		return jdbcTemplate.queryForObject(userSelect.toString(), param, mapper);
	}//end of method

	
	//==> ȸ������ ::  UPDATE  ( ȸ������ ����  )
	public int updateUser(User user) throws Exception {
		StringBuffer userUpdate = new StringBuffer();
		userUpdate.append("UPDATE users ");
		//userUpdate.append("SET user_name = ?,password=?,age=? ");
		userUpdate.append("SET user_name =:name,password=:password,age=:age ");
		//userUpdate.append("WHERE user_id=?");
		userUpdate.append("WHERE user_id=:id");
		
	//	NamedParameterJdbcTemplate �� �Ķ������ ���ε��Ǵ� ������ �߿����� �ʴ�(���� :: Map���)
		
		Map paramMap = new HashMap();
		paramMap.put("name", user.getUserName());
		paramMap.put("password", user.getPassword());
		paramMap.put("age", user.getAge());
		paramMap.put("id", user.getUserId());
		
		return namedParameterJdbcTemplate.update(userUpdate.toString(), paramMap);
		
	}	
	
	//==> ȸ������ ::  DELETE  ( ȸ������ ���� )
	public int removeUser(String userId) throws Exception{
		StringBuffer  userDelete = new StringBuffer();
		userDelete.append("DELETE ");
		userDelete.append("FROM USERS ");
		userDelete.append("WHERE user_id=:id");
		
		Map paramMap = new HashMap();
		paramMap.put("id", userId);
		
		return namedParameterJdbcTemplate.update(userDelete.toString(),paramMap);
		
	}//end of class
	
	
	//==> ȸ������ ::  SELECT  ( ��� ȸ�� ���� �˻� )
	public List<User> getUserList() throws Exception {
		StringBuffer userSelectList = new StringBuffer();
		
		userSelectList.append("SELECT user_id, user_name, age, reg_date ");
		userSelectList.append("FROM users");
		
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		return jdbcTemplate.query(userSelectList.toString(), mapper);
	}//end of Method
	
}//end of class

/*
 * ������ ::

 */




















