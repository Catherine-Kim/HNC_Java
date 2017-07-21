package service;

import java.util.List;

import persistence.User;

public interface UserService {
	//==> 회원정보 ::  INSERT ( 회원가입 )
		public int addUser(User user) throws Exception;
		
		//==> 회원정보 ::  SELECT  ( 회원정보 검색 ) 
		public User getUser(String userId) throws Exception ;

		//==> 회원정보 ::  UPDATE  ( 회원정보 변경  )
		public int updateUser(User user) throws Exception ;
	
		//==> 회원정보 ::  SELECT  ( 모든 회원 정보 검색 )
		public List<User> getUserList() throws Exception ;
}
