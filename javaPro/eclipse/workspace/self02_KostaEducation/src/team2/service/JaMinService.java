package team2.service;

import java.util.Scanner;
import team2.vo.StudentVO;
import team2.vo.child.CafeVO;
import team2.vo.child.PubVO;
import team2.vo.child.RestaurantVO;
import team2.vo.parent.CompanyVO;

public class JaMinService {
	
	// 학생 리스트의 정보 출력
	public void printStudentInfo(StudentVO[] stu){
		for(StudentVO s : stu){
			System.out.println(s);
		}
	} // printStudentInfo 메소드 끝
	
	// 학생 프로필 출력(이름, 고유번호, 잔액, 마일리지)
	public void printStudentProfile(StudentVO[] stu, int serialNo){
		for(StudentVO st : stu){
			if(st.getSerialNo()==serialNo){
				System.out.println(st.toString());
			}
		}
	}	// printStudentProfile 메소드 끝
 
	// 학생이 갈 수 있는 업체 정보 출력
	public void printMyCompany(StudentVO[] s, int serialNo){
		for(int i=0 ; i<s.length ; i++){
			if(s[i].getSerialNo() == serialNo){
				for(int j=0 ; j<s[i].getCompanyList().length ; j++){
                	System.out.println(s[i].getCompanyList()[j]);
            	}//inner for	
        	}//if
        	break;
    	}//outer for
	}// printMyCompany 메소드 끝


 
	//구매 메소드
	public void buySomething(StudentVO[] stu, int user_serialNo){
		int mileage_price = 0;
		int discount_price = 0;
		int userChoice = 0;
  
		for(StudentVO st : stu){
			if(st.getSerialNo()==user_serialNo){  //입력받은 고유번호와 일치하는 학생을 찾는다면
				System.out.println("사용하실 업체를 선택해주세요.");
    
				int index = 0;
    
				printMyCompany(stu, user_serialNo);	// Kosta와 제휴한 업체 정보 출력
    
				Scanner sc = new Scanner(System.in);
				int company_index = sc.nextInt();	// 구매가 이루어질 업체 index 입력받음
				
				System.out.println(st.getCompanyList()[company_index].getName() + "에서 지불하실 금액을 입력해 주세요.");
				int userPrice = sc.nextInt();		// 지불할 금액 입력
    
				System.out.println(st.getCompanyList()[company_index].getName() + "에서 " + userPrice + "원을 지불합니다.");
				System.out.println("현금으로 지불하려면 1번, 적립금으로 지불하려면 2번 눌러주세요.");
				userChoice = sc.nextInt();			// 지불 방식 선택(현금 or 적립금)
    
				if(userChoice == 1){ 				// 현금으로 지불
					System.out.println("현금으로 지불하는 것을 선택하셨습니다.");
					System.out.println("1.적립/2.할인을 선택해 주세요.");
					userChoice = sc.nextInt();		// 혜택 받을 방식 선택(적립 or 할인)
   
					if(userChoice==1){ // 적립 선택
						System.out.println("적립을 선택하셨습니다.");
						
						// 클래스를 구별해서 해당 클래스에 맞는 적립률로 적립할 금액을 산출
						if(st.getCompanyList()[company_index] instanceof CafeVO) 
							mileage_price = (int)(((CafeVO)st.getCompanyList()[company_index]).getMILEAGE_RATE() * userPrice);
						else if(st.getCompanyList()[company_index] instanceof PubVO)
							mileage_price = (int)(((PubVO)st.getCompanyList()[company_index]).getMILEAGE_RATE() * userPrice);
						else
							mileage_price = (int)(((RestaurantVO)st.getCompanyList()[company_index]).getMILEAGE_RATE() * userPrice);
						
						System.out.println(mileage_price + "원 적립하였습니다.");
						st.setBalance(st.getBalance()-userPrice);		// 기존 잔액에서 지불 금액 차감
						st.setMileage(st.getMileage() + mileage_price);	// 기존 적립금에 적립할 금액 더함
						printStudentProfile(stu, user_serialNo);		// 바뀐 고객 정보 출력
					}
					else{    // 할인 선택
						System.out.println("할인을 선택하셨습니다.");
						
						// 클래스를 구별해서 해당 클래스에 맞는 할인률로 할인할 금액을 산출
						if(st.getCompanyList()[company_index] instanceof CafeVO) 
							discount_price = (int)(((CafeVO)st.getCompanyList()[company_index]).getDISCOUNT_RATE() * userPrice);
						else if(st.getCompanyList()[company_index] instanceof PubVO)
							discount_price = (int)(((PubVO)st.getCompanyList()[company_index]).getDISCOUNT_RATE() * userPrice);
						else
							discount_price = (int)(((RestaurantVO)st.getCompanyList()[company_index]).getDISCOUNT_RATE() * userPrice);
     
						// 기존 잔액에 지불 금액에서 할인 금액을 뺀 가격 차감
						System.out.println(discount_price + "원 할인되었습니다.");
						st.setBalance(st.getBalance()-(userPrice-discount_price));
						printStudentProfile(stu, user_serialNo);	// 바뀐 고객 정보 출력
					}
				}
				
				else{  // 적립금으로 지불
					System.out.println("적립금으로 지불하는 것을 선택하셨습니다.");
					st.setMileage(st.getMileage() - userPrice);
					printStudentProfile(stu, user_serialNo);
				}
			}
		}
	} // buySomething 메소드 끝
 
	// 프로그램 시작 메소드
	public void startProgram(StudentVO[] stu){
		System.out.println("고유번호를 입력해주세요.");	// 사용자 고유번호를 받음
		Scanner sc = new Scanner(System.in);
		int user_serialNo = sc.nextInt();
  
		System.out.println("정보조회 : 1 | 구매는: 2");	// 프로그램의 두 가지 기능 중 하나 선택(정보조회 or 구매)
		int startChoiceNo = sc.nextInt();
  
		if(startChoiceNo==1){   // 정보 조회 선택
			System.out.println("고객정보조회 : 1 | 업체정보조회: 2");	// 고객 정보 조회와 업체 정보 조회 중 하나 선택
			startChoiceNo = sc.nextInt();
			
			if(startChoiceNo==1){  // if 2
				printStudentProfile(stu, user_serialNo);	// 고객 정보 선택 -> 고객 정보 출력 메소드 호출
			}
			else if(startChoiceNo==2){
				printMyCompany(stu, user_serialNo);			// 업체 정보 조회 -> 업체 정보 출력 메소드 호출 
			}
			else{
				System.out.println("잘못된 값을 입력하셨습니다.");
			}
		}
		else if(startChoiceNo==2){		// 구매 선택 -> 구매 메소드 호출
			buySomething(stu, user_serialNo);
		}
		else{
			System.out.println("잘못된 값을 입력하셨습니다.");
		}
	} // startProgram 메소드 끝
}

