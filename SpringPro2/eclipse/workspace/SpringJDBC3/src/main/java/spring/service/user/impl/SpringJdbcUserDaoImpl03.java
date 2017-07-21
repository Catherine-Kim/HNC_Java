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
	
	// constructor 추가
	public SpringJdbcUserDaoImpl03() {
		System.out.println(":: " + getClass().getName() + "() Default Constructor");
	}

	///Method
	//==> 회원정보 ::  INSERT ( 회원가입 )
	public int addUser(User user)  throws Exception{
		// 쿼리문이 길어질 수 있기 때문에 StringBuffer 사용
		StringBuffer userInsert = new StringBuffer();
		
		// 쿼리문
		userInsert.append("INSERT INTO users ");
		userInsert.append("(user_id, user_name, password, age) ");
		userInsert.append("VALUES(?, ?, ?, ?)");
		
		
		// 쿼리문에 바인딩할 정보를 담은 Object 배열
		Object[] args = new Object[]{
				user.getUserId(),
				user.getUserName(),
				user.getPassword(),
				user.getAge(),
		};
		
		return getJdbcTemplate().update(userInsert.toString(), args);
	}	
	
			
	//==> 회원정보 ::  SELECT  ( 회원정보 검색 ) 
	public User getUser(String userId) throws Exception {
		StringBuffer userSelect = new StringBuffer();
		Object[] param = new Object[]{userId};
		
		userSelect.append("SELECT user_id, user_name, age, reg_date ");
		userSelect.append("FROM users ");
		userSelect.append("WHERE user_id = ?");
		
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		return getJdbcTemplate().queryForObject(userSelect.toString(), param, mapper);
	}//end of method

	
	//==> 회원정보 ::  UPDATE  ( 회원정보 변경  )
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
	
	//==> 회원정보 ::  DELETE  ( 회원정보 삭제 )
	public int removeUser(String userId) throws Exception{
		StringBuffer  userDelete = new StringBuffer();
		userDelete.append("DELETE ");
		userDelete.append("FROM USERS ");
		userDelete.append("WHERE user_id=?");
		
		Object[] args = {userId};
		
		return getJdbcTemplate().update(userDelete.toString(),args);
		
	}//end of class
	
	
	//==> 회원정보 ::  SELECT  ( 모든 회원 정보 검색 )
	public List<User> getUserList() throws Exception {
		StringBuffer userSelectList = new StringBuffer();
		
		userSelectList.append("SELECT user_id, user_name, age, reg_date ");
		userSelectList.append("FROM users");
		
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		return getJdbcTemplate().query(userSelectList.toString(), mapper);
	}//end of Method
	
}//end of class

/*
 * 문제점 ::

 */




















