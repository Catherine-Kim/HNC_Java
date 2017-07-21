package spring.service.user;

import java.util.List;

import spring.service.domain.User;

/* 
 * FileName : UserDao.java  ( Data Access Object ) 
 * :: Persistence(?) Layer �������̽�
*/ 
public interface UserDao{
	
	//==> ȸ������ ::  INSERT ( ȸ������ )
	public int addUser(User user) throws Exception;
	
	//==> ȸ������ ::  SELECT  ( ȸ������ �˻� ) 
	public User getUser(String userId) throws Exception ;

	//==> ȸ������ ::  UPDATE  ( ȸ������ ����  )
	public int updateUser(User user) throws Exception ;
	
	//==> ȸ������ ::  DELETE  ( ȸ������ ���� )
	public int removeUser(String userId) throws Exception;
	
	//==> ȸ������ ::  SELECT  ( ��� ȸ�� ���� �˻� )
	public List<User> getUserList() throws Exception ;
	
}//end of class