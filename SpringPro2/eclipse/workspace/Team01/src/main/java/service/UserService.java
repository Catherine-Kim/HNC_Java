package service;

import java.util.List;

import persistence.User;

public interface UserService {
	//==> ȸ������ ::  INSERT ( ȸ������ )
		public int addUser(User user) throws Exception;
		
		//==> ȸ������ ::  SELECT  ( ȸ������ �˻� ) 
		public User getUser(String userId) throws Exception ;

		//==> ȸ������ ::  UPDATE  ( ȸ������ ����  )
		public int updateUser(User user) throws Exception ;
	
		//==> ȸ������ ::  SELECT  ( ��� ȸ�� ���� �˻� )
		public List<User> getUserList() throws Exception ;
}
