package team2.vo.parent;
public class CompanyVO {
 //fields
   private String name;    	// 업체 이름 ex.이디야, 새마을식당 등
  
   public CompanyVO() {}
   public CompanyVO(String name) {
   this.name = name;
  }
 public String getName() {
  return name;
 }
 public void setName(String name) {
  this.name = name;
 }
 @Override
 public String toString() {
  return "업체명 : " + name;
 }
 	
}

