package spring.service.user;

import java.util.List;

import spring.service.domain.User;

public interface UserService {
	//==> ȸ������ ::  INSERT ( ȸ������ )
		public int addUser(User user) throws Exception;
		
		//==> ȸ������ ::  SELECT  ( ȸ������ �˻� ) 
		public User getUser(String userId) throws Exception ;

		//==> ȸ������ ::  UPDATE  ( ȸ������ ����  )
		public int updateUser(User user) throws Exception ;
	
		//==> ȸ������ ::  SELECT  ( ��� ȸ�� ���� �˻� )
		public List<User> getUserList(User user) throws Exception ;
}
