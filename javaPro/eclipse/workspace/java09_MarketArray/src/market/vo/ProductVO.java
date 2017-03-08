package market.vo;

import market.util.MyDate;

/*
 *  ��ǰ�� ���� ������ ��� �ִ� VOŬ����
 *  : 
 *  maker, price, serialNumber, startData 
 */
public class ProductVO {
	private String maker;
	private int price;
	private int serialNumber;
	private MyDate startData; //�԰����
	
	/*
	 * ������, setter, getter ����
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
