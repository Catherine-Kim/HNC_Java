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
	// field 추가
	@Inject
	@Named("sqlService")
	private SqlService sqlService;

	// constructor 추가
	public SpringJdbcUserDaoImpl09() {
		System.out.println(":: " + getClass().getName() + "() Default Constructor");
	}

	///Method
	//==> 회원정보 ::  INSERT ( 회원가입 )
	public int addUser(User user)  throws Exception{		
		// 쿼리문에 바인딩할 정보를 담은 Object 배열
		Object[] args = new Object[]{
				user.getUserId(),
				user.getUserName(),
				user.getPassword(),
				user.getAge(),
				user.getRegDate()
		};
		
		return getJdbcTemplate().update(sqlService.getSql("user.sql.insert"), args);
	}	
	
			
	//==> 회원정보 ::  SELECT  ( 회원정보 검색 ) 
	public User getUser(String userId) throws Exception {
		Object[] param = new Object[]{userId};
		
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		return getJdbcTemplate().queryForObject(sqlService.getSql("user.sql.select"), param, mapper);
	}//end of method

	
	//==> 회원정보 ::  UPDATE  ( 회원정보 변경  )
	public int updateUser(User user) throws Exception {
		Object[] args = {
			user.getUserName(),
			user.getPassword(),
			user.getAge(),
			user.getUserId()
		};
		
		return getJdbcTemplate().update(sqlService.getSql("user.sql.update"), args);
	}	
	
	//==> 회원정보 ::  DELETE  ( 회원정보 삭제 )
	public int removeUser(String userId) throws Exception{		
		Object[] args = {userId};
		
		return getJdbcTemplate().update(sqlService.getSql("user.sql.delete").toString(),args);
		
	}//end of class
	
	
	//==> 회원정보 ::  SELECT  ( 모든 회원 정보 검색 )
	public List<User> getUserList() throws Exception {
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		return getJdbcTemplate().query(sqlService.getSql("user.sql.selectAll"), mapper);
	}//end of Method
	
}//end of class

/*
 * 문제점 ::

 */




















