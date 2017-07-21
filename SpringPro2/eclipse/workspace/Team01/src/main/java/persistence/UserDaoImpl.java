package persistence;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class UserDaoImpl extends JdbcDaoSupport implements UserDao{
	// field �߰�
	private SqlService sqlService;

	// setter �߰�
	public void setSqlService(SqlService sqlService) {
		this.sqlService = sqlService;
	}

	// constructor �߰�
	public UserDaoImpl() {
		System.out.println(":: " + getClass().getName() + "() Default Constructor");
	}

	///Method
		//==> ȸ������ ::  INSERT ( ȸ������ )
		public int addUser(User user)  throws Exception{
			
			Object[ ] args = new Object[]{
					user.getUserId(),
					user.getUserName(),
					user.getPassword(),
					user.getAge(),
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




















