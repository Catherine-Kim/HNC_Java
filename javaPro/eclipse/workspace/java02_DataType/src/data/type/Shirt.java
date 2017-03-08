package data.type;

/*
 * Shirt Class ::
 * 해당 클래스에서는 8가지 기본형 데이타 타입 사용
 * 정수형 : byte, int(default), short, long -> default value = 0
 * 실수형 : float, double(default) -> default value = 0.0
 * 문자형 : char -> default value = '\u0000'
 * 논리형 : boolean -> default value = false
 * ------------------------------------------------------------
 * 8가지 기본형(Primitive Data Type)을 제외한 모든 데이터 타입은
 * Class(Reference) Data Type에 속한다. -> default value = null
 * 
 * Class(Reference Data Type
 * 1) 사용자 정의 클래스(User Definition Class)
 * 2) API 클래스
 */

public class Shirt {
	// 필드 선언
	String brand;
	int codeNo;
	boolean longSleeved;
	float price;
	char size;

	public void setShirtInfo(String brand, int codeNo, 
			boolean longSleeved, float price, char size){
		this.brand = brand;
		this.codeNo = codeNo;
		this.longSleeved = longSleeved;
		this.price = price;
		this.size = size;
	}

	public String getBrand() {
		return brand;
	}

	public int getCodeNo() {
		return codeNo;
	}

	public boolean isLongSleeved() {
		return longSleeved;
	}

	public float getPrice() {
		return price;
	}

	public char getSize() {
		return size;
	}
	
}
