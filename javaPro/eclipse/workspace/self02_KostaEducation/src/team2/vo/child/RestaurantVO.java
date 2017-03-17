package team2.vo.child;
import team2.vo.parent.CompanyVO;
public class RestaurantVO extends CompanyVO{
 // fields
 private static final double DISCOUNT_RATE = 0.1;    	// ÇÒÀÎ·ü 10%
 private static final double MILEAGE_RATE = 0.1;    	// Àû¸³·ü 10%
  
 public RestaurantVO(String name) {
  super(name); 
 }
 
 public static double getDISCOUNT_RATE() {
  return DISCOUNT_RATE;
 }
 public static double getMILEAGE_RATE() {
  return MILEAGE_RATE;
 }
 @Override
 public String toString() {
  return super.toString()+ "ÇÒÀÎ·ü : "+ DISCOUNT_RATE + "Àû¸³·ü : " + MILEAGE_RATE ;
 }

}

