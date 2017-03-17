package team2.vo;
import java.util.Arrays;
import team2.vo.parent.CompanyVO;
public class StudentVO {
 // fields	
 	private String name;    	// 학생 이름
 	private int serialNo;    	// 학생 고유번호
 	private int balance;    	// 잔액
 	private int mileage;    	// 마일리지(적립금)
 	CompanyVO[] companyList;	// 업체 리스트
  
 	public StudentVO() {}
  public StudentVO(String name, int serialNo, int balance, int mileage,  CompanyVO[] companyList) {
   super();
   this.name = name;
   this.serialNo = serialNo;
   this.balance = balance;
   this.mileage = mileage;
   this.companyList = companyList;
  }
  
  public String getName() {
   return name;
  }
  public void setName(String name) {
   this.name = name;
  }
  public int getSerialNo() {
   return serialNo;
  }
  public void setSerialNo(int serialNo) {
   this.serialNo = serialNo;
  }
  public int getBalance() {
   return balance;
  }
  public void setBalance(int balance) {
   this.balance = balance;
  }
  public int getMileage() {
   return mileage;
  }
  public void setMileage(int mileage) {
   this.mileage = mileage;
  }
  public CompanyVO[] getCompanyList() {
   return companyList;
  }
  public void setCompanyList(CompanyVO[] companyList) {
   this.companyList = companyList;
  }
  @Override
  public String toString() {
   return "학생이름: " + name + " 고유번호: " + serialNo + " 잔액: " + balance + " 마일리지: "
     + mileage;
  }
 	
  
}

