package team2.vo.parent;
public class CompanyVO {
 //fields
   private String name;    	// ��ü �̸� ex.�̵��, �������Ĵ� ��
  
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
  return "��ü�� : " + name;
 }
 	
}

