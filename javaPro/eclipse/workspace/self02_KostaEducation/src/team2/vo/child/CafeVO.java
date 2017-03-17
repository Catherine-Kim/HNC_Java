package team2.vo.child;
import team2.vo.parent.CompanyVO;
public class CafeVO extends CompanyVO {
 // fields
 	private double DISCOUNT_RATE = 0.3;    	// ÇÒÀÎ·ü 30%
 	private double MILEAGE_RATE = 0.1;    	// Àû¸³·ü 10%
 
  public CafeVO(String name) {
   super(name);
  }
  
  public double getDISCOUNT_RATE() {
   return DISCOUNT_RATE;
  }
  public double getMILEAGE_RATE() {
   return MILEAGE_RATE;
  }
  @Override
  public String toString() {
   return super.toString()+ "ÇÒÀÎ·ü : "+ DISCOUNT_RATE + "Àû¸³·ü : " + MILEAGE_RATE ;
  }
  
 
}

