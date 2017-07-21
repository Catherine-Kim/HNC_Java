package spring.service.user.impl;

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

public class SpringJdbcUserDaoImpl01 implements UserDao{
	// field 추가
	private DataSource dataSource;
	
	// setter 추가
	public void setDataSource(DataSource dataSource) {
		System.out.println(":: " + getClass().getName() + ".setDataSource() 호출");
		this.dataSource = dataSource;
	}

	// constructor 추가
	public SpringJdbcUserDaoImpl01() {
		System.out.println(":: " + getClass().getName() + "() Default Constructor");
	}
	
	///Method
	//==> 회원정보 ::  INSERT ( 회원가입 )
		public int addUser(User user)  throws Exception{
			StringBuffer userInsert = new StringBuffer();
			userInsert.append("INSERT INTO users ");
			userInsert.append("(user_id, user_name, password, age, reg_date) ");
			userInsert.append("VALUES(?,?,?,?,?)");
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			Object[ ] args = new Object[]{
					user.getUserId(),
					user.getUserName(),
					user.getPassword(),
					user.getAge(),
					user.getRegDate()
			};
			return jdbcTemplate.update(userInsert.toString(), args);
		}	
	
			
		
	//==> 회원정보 ::  SELECT  ( 회원정보 검색 ) 
	public User getUser(String userId) throws Exception {
		String userSelect = "SELECT * FROM  users WHERE user_id=?";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		Object[ ] args = {userId};
		BeanPropertyRowMapper<User> mapper = 
				new BeanPropertyRowMapper<User>(User.class);

		return jdbcTemplate.queryForObject(userSelect,args, mapper);
	}//end of method


	//==> 회원정보 ::  UPDATE  ( 회원정보 변경  )
	public int updateUser(User user) throws Exception {
		StringBuffer userUpdate = new StringBuffer();
		userUpdate.append("UPDATE users ");
		//userUpdate.append("SET user_name = ?,password=?,age=? ");
		userUpdate.append("SET user_name =:name,password=:password,age=:age ");
		//userUpdate.append("WHERE user_id=?");
		userUpdate.append("WHERE user_id=:id");
		
	//	NamedParameterJdbcTemplate 은 파라미터의 바인딩되는 순서는 중요하지 않다(이유 :: Map방식)
		NamedParameterJdbcTemplate jdbcTemplate =new NamedParameterJdbcTemplate(dataSource);
		
		
		Map paramMap = new HashMap();
		paramMap.put("name", user.getUserName());
		paramMap.put("password", user.getPassword());
		paramMap.put("age", user.getAge());
		paramMap.put("id", user.getUserId());
		
		return jdbcTemplate.update(userUpdate.toString(), paramMap);
		
	}	
	
	//==> 회원정보 ::  DELETE  ( 회원정보 삭제 )
	public int removeUser(String userId) throws Exception{
		StringBuffer  userDelete = new StringBuffer();
		userDelete.append("DELETE ");
		userDelete.append("FROM USERS ");
		userDelete.append("WHERE user_id=:id");
		
		NamedParameterJdbcTemplate jdbcTemplate =new NamedParameterJdbcTemplate(dataSource);
		Map paramMap = new HashMap();
		paramMap.put("id", userId);
		
		return jdbcTemplate.update(userDelete.toString(),paramMap);
		
	}//end of class
	
	//==> 회원정보 ::  SELECT  ( 모든 회원 정보 검색 )
	public List<User> getUserList() throws Exception {
		StringBuffer userSelectList = new StringBuffer();
		
		userSelectList.append("SELECT user_id, user_name, age, reg_date ");
		userSelectList.append("FROM users");
		
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query(userSelectList.toString(), mapper);
	}//end of Method
	
}//end of class

/*
 * 문제점 ::

 */




















