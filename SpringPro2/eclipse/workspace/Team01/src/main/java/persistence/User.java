package persistence;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/* 
 * FileName : User.java  
 * ::User �� ������ ���� Value Object :: Domain Object :: Commnad Object
*/ 
public class User implements Serializable {

	///Field
    private String userId; 			/* ȸ�� ID */
    private String userName;		/* ȸ�� �̸� */
    private String password;		/* ��й�ȣ */
    private int age;							/* ���� */
    /* �������� */
    private Timestamp regDate	= new Timestamp(new Date().getTime()); 
    private boolean active = true;
    
    ///Constructor
    public User() {
	}
    public User(String userId, String userName, String password, int age) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.age = age;
	}    

	///Method (getter/setter)
	public String getUserId(){
		return this.userId;
	}
	public void setUserId( String userId ){
	   this.userId= userId;
	}
	public String getPassword(){
	   return this.password;
	}
	public void setPassword( String password ){
	   this.password= password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public java.sql.Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(java.sql.Timestamp regDate) {
		this.regDate = regDate;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isActive() {
		return active;
	}
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append(" [userId] " + userId);
		sb.append(" [userName] " + userName);
		sb.append(" [password] " + password);		
		sb.append(" [age] " + age);
		sb.append(" [regDate] " + regDate);
		sb.append(" [active] " + active);
         return  	sb.toString();
	}
}//end of class