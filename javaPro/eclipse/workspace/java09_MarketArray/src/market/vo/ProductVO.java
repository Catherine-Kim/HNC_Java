package market.vo;

import market.util.MyDate;

/*
 *  상품에 대한 정보를 담고 있는 VO클래스
 *  : 
 *  maker, price, serialNumber, startData 
 */
public class ProductVO {
	private String maker;
	private int price;
	private int serialNumber;
	private MyDate startData; //입고시점
	
	/*
	 * 생성자, setter, getter 생성
	 */
	
	public ProductVO(String maker, int price, int serialNumber, MyDate startData) {
		this.maker = maker;
		this.price = price;
		this.serialNumber = serialNumber;
		this.startData = startData;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public MyDate getStartData() {
		return startData;
	}

	public void setStartData(MyDate startData) {
		this.startData = startData;
	}	

}
