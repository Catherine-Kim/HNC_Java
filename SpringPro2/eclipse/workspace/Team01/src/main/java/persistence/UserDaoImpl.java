package persistence;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class UserDaoImpl extends JdbcDaoSupport implements UserDao{
	// field 추가
	private SqlService sqlService;

	// setter 추가
	public void setSqlService(SqlService sqlService) {
		this.sqlService = sqlService;
	}

	// constructor 추가
	public UserDaoImpl() {
		System.out.println(":: " + getClass().getName() + "() Default Constructor");
	}

	///Method
		//==> 회원정보 ::  INSERT ( 회원가입 )
		public int addUser(User user)  throws Exception{
			
			Object[ ] args = new Object[]{
					user.getUserId(),
					user.getUserName(),
					user.getPassword(),
					user.getAge(),
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




















