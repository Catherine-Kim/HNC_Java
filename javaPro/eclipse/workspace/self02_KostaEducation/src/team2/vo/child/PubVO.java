package team2.vo.child;
import team2.vo.parent.CompanyVO;
public class PubVO extends CompanyVO {
 // fields
 private double DISCOUNT_RATE = 0.2;    	// ���η� 20%
 private double MILEAGE_RATE = 0.1;    	// ������ 10%
 
 
 public PubVO(String name) {
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
  return super.toString()+ "���η� : "+ DISCOUNT_RATE + "������ : " + MILEAGE_RATE ;
 }
 
}

