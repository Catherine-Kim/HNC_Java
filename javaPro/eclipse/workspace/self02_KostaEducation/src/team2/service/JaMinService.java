package team2.service;

import java.util.ArrayList;
import java.util.Scanner;

import team2.exception.BuyException;
import team2.vo.StudentVO;
import team2.vo.child.CafeVO;
import team2.vo.child.PubVO;
import team2.vo.child.RestaurantVO;
import team2.vo.parent.CompanyVO;

public class JaMinService {
	   
	   // �л� ����Ʈ�� ���� ���
	   public void printStudentInfo(ArrayList<StudentVO> stuList){
	      for(int i= 0; i<stuList.size(); i++ ){
	         System.out.println(stuList.get(i));
	      }
	   
	   } // printStudentInfo �޼ҵ� ��
	   
	   // �л� ������ ���(�̸�, ������ȣ, �ܾ�, ���ϸ���)
	   public void printStudentProfile(ArrayList<StudentVO> stuList, int serialNo){
	      for(int i = 0; i<stuList.size(); i++ ){
	         if(stuList.get(i).getSerialNo()== serialNo){
	            System.out.println(stuList.get(i));
	         }
	      }
	   }   // printStudentProfile �޼ҵ� ��
	 
	   // �л��� �� �� �ִ� ��ü ���� ���
	   public void printStudentCompany(ArrayList<StudentVO> stuList, int serialNo){
	      for(int i=0 ; i<stuList.size(); i++){
	         if(stuList.get(i).getSerialNo()==serialNo){
	            for(int ii=0 ; ii<stuList.get(i).getCompanyList().length; ii++){
	               System.out.println(stuList.get(i).getCompanyList()[ii]);
	            }
	         }
	         
	      }
	         
	        
	   }// printMyCompany �޼ҵ� ��


	 
	   //���� �޼ҵ�
	   public void buySomething(ArrayList<StudentVO> stu, int user_serialNo){
	      int mileage_price = 0;
	      int discount_price = 0;
	      int userChoice = 0;
	  
	      for(StudentVO st : stu){
	         if(st.getSerialNo()==user_serialNo){  //�Է¹��� ������ȣ�� ��ġ�ϴ� �л��� ã�´ٸ�
	            System.out.println("����Ͻ� ��ü�� �������ּ���.");
	    
	    
	            printStudentCompany(stu, user_serialNo);   // Kosta�� ������ ��ü ���� ���
	    
	            Scanner sc = new Scanner(System.in);
	            int company_index = sc.nextInt();   // ���Ű� �̷���� ��ü index �Է¹���
	            
	            System.out.println(st.getCompanyList()[company_index].getName() + "���� �����Ͻ� �ݾ��� �Է��� �ּ���.");
	            int userPrice = sc.nextInt();      // ������ �ݾ� �Է�
	    
	            System.out.println(st.getCompanyList()[company_index].getName() + "���� " + userPrice + "���� �����մϴ�.");
	            System.out.println("�������� �����Ϸ��� 1��, ���������� �����Ϸ��� 2�� �����ּ���.");
	            userChoice = sc.nextInt();         // ���� ��� ����(���� or ������)
	    
	            if(userChoice == 1){             // �������� ����
	               System.out.println("�������� �����ϴ� ���� �����ϼ̽��ϴ�.");
	               System.out.println("1.����/2.������ ������ �ּ���.");
	               userChoice = sc.nextInt();      // ���� ���� ��� ����(���� or ����)
	   
	               if(userChoice==1){ // ���� ����
	                  System.out.println("������ �����ϼ̽��ϴ�.");
	                  
	                  // Ŭ������ �����ؼ� �ش� Ŭ������ �´� �������� ������ �ݾ��� ����
	                  if(st.getCompanyList()[company_index] instanceof CafeVO) 
	                     mileage_price = (int)(((CafeVO)st.getCompanyList()[company_index]).getMILEAGE_RATE() * userPrice);
	                  else if(st.getCompanyList()[company_index] instanceof PubVO)
	                     mileage_price = (int)(((PubVO)st.getCompanyList()[company_index]).getMILEAGE_RATE() * userPrice);
	                  else
	                     mileage_price = (int)(((RestaurantVO)st.getCompanyList()[company_index]).getMILEAGE_RATE() * userPrice);
	                  
	                  System.out.println(mileage_price + "�� �����Ͽ����ϴ�.");
	                  st.setBalance(st.getBalance()-userPrice);      // ���� �ܾ׿��� ���� �ݾ� ����
	                  st.setMileage(st.getMileage() + mileage_price);   // ���� �����ݿ� ������ �ݾ� ����
	                  printStudentProfile(stu, user_serialNo);      // �ٲ� �� ���� ���
	               }
	               else{    // ���� ����
	                  System.out.println("������ �����ϼ̽��ϴ�.");
	                  
	                  // Ŭ������ �����ؼ� �ش� Ŭ������ �´� ���η��� ������ �ݾ��� ����
	                  if(st.getCompanyList()[company_index] instanceof CafeVO) 
	                     discount_price = (int)(((CafeVO)st.getCompanyList()[company_index]).getDISCOUNT_RATE() * userPrice);
	                  else if(st.getCompanyList()[company_index] instanceof PubVO)
	                     discount_price = (int)(((PubVO)st.getCompanyList()[company_index]).getDISCOUNT_RATE() * userPrice);
	                  else
	                     discount_price = (int)(((RestaurantVO)st.getCompanyList()[company_index]).getDISCOUNT_RATE() * userPrice);
	     
	                  // ���� �ܾ׿� ���� �ݾ׿��� ���� �ݾ��� �� ���� ����
	                  System.out.println(discount_price + "�� ���εǾ����ϴ�.");
	                  st.setBalance(st.getBalance()-(userPrice-discount_price));
	                  printStudentProfile(stu, user_serialNo);   // �ٲ� �� ���� ���
	               }
	            }
	            
	            else{  // ���������� ����
	               System.out.println("���������� �����ϴ� ���� �����ϼ̽��ϴ�.");
	               st.setMileage(st.getMileage() - userPrice);
	               printStudentProfile(stu, user_serialNo);
	            }
	         }
	      }
	   } // buySomething �޼ҵ� ��
	 

	// ���α׷� ���� �޼ҵ�
	public void startProgram(ArrayList<StudentVO> stu) {
		boolean closeProgram = false;

		System.out.println("������ȣ�� �Է����ּ���."); // ����� ������ȣ�� ����
		Scanner sc = new Scanner(System.in);
		int user_serialNo = sc.nextInt();
		
		while (!closeProgram) {
			System.out.println("\n������ȸ : 1 | ���Ŵ�: 2 | ���α׷� ���� : 3"); // ���α׷��� �� ���� ��� �� �ϳ�
														// ����(������ȸ or ����)
			int startChoiceNo = sc.nextInt();

			if (startChoiceNo == 1) { // ���� ��ȸ ����
				System.out.println("��������ȸ : 1 | ��ü������ȸ: 2"); // �� ���� ��ȸ�� ��ü ����
																// ��ȸ �� �ϳ� ����
				startChoiceNo = sc.nextInt();

				if (startChoiceNo == 1) { // if 2
					printStudentProfile(stu, user_serialNo); // �� ���� ���� -> ��
																// ���� ��� �޼ҵ� ȣ��
				} else if (startChoiceNo == 2) {
					printStudentCompany(stu, user_serialNo); // ��ü ���� ��ȸ -> ��ü
																// ���� ��� �޼ҵ� ȣ��
				} else {
					System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�.");
				}
			} else if (startChoiceNo == 2) { // ���� ���� -> ���� �޼ҵ� ȣ��
				buySomething(stu, user_serialNo);
			} else if (startChoiceNo == 3) {
				closeProgram = true;		
			} else{
				System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�. 1���� 3 �� �ϳ��� ����ּ���.");
			}
		}
		System.out.println("���α׷��� �����մϴ�.");
		return;
	} // startProgram �޼ҵ� ��
}
