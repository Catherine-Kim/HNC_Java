package team2.vo;
import java.util.Arrays;
import team2.vo.parent.CompanyVO;
public class StudentVO {
 // fields	
 	private String name;    	// �л� �̸�
 	private int serialNo;    	// �л� ������ȣ
 	private int balance;    	// �ܾ�
 	private int mileage;    	// ���ϸ���(������)
 	CompanyVO[] companyList;	// ��ü ����Ʈ
  
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
   return "�л��̸�: " + name + " ������ȣ: " + serialNo + " �ܾ�: " + balance + " ���ϸ���: "
     + mileage;
  }
 	
  
}

