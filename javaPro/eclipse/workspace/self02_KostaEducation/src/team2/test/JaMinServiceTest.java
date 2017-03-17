
package team2.test;

import team2.service.JaMinService;
import team2.vo.StudentVO;
import team2.vo.child.CafeVO;
import team2.vo.child.PubVO;
import team2.vo.child.RestaurantVO;
import team2.vo.parent.CompanyVO;

public class JaMinServiceTest {
	public static void main(String[] args) {
    	// Initialization
    	CompanyVO com1 = new CafeVO("Å½¾ØÅ½½º");
    	CompanyVO com2 = new CafeVO("ÀÌµð¾ß");
    	CompanyVO com3 = new CafeVO("ÆÄ½ºÄíÄ¡");
    	CompanyVO com4 = new RestaurantVO("»õ¸¶À»½Ä´ç");
    	CompanyVO com5 = new RestaurantVO("ºÀÃßÂò´ß");
    	CompanyVO com6 = new RestaurantVO("µµ½º¸¶½º");
    	CompanyVO com7 = new PubVO("ÇÑ½ÅÆ÷Â÷");
    	CompanyVO com8 = new PubVO("ºñ¾îÅ·");
    	CompanyVO com9 = new PubVO("Â¦");
    	CompanyVO com10 = new PubVO("»ýÈ°¸ÆÁÖ");
   	
    	
    	CompanyVO[] companies = {com1, com2, com3, com4, com5, com6, com7, com8, com9, com10};
    	
    	//StudentVO(String name, int serialNo, int balance, int mileage,  CompanyVO[] companyList)
    	StudentVO stuKWJ = new StudentVO("±è¿ìÁ¤", 111, 30000, 20000, companies);
    	StudentVO stuCIW = new StudentVO("ÃÖÀÏ¿õ", 222, 20000, 15000, companies);
    	StudentVO stuJJH = new StudentVO("ÀüÁ¾Çö", 333, 60000, 25000, companies);
    	StudentVO stuKJS = new StudentVO("±èÁ¤½Ä", 444, 10000, 10000, companies);
    	
    	StudentVO[] stuList = {stuKWJ, stuCIW, stuJJH, stuKJS};
    	JaMinService jms = new JaMinService();
    	
    	jms.printStudentInfo(stuList);
    	jms.startProgram(stuList);
    	
	}
}


