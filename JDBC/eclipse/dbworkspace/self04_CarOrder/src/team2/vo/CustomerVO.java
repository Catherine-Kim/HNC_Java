package team2.vo;

import java.util.ArrayList;

public class CustomerVO {
	// fields
	private String custId;
	private String name;
	private String address;
	private String tel;
	private ArrayList<CarOrderVO> orderList;
	
	// constructors
	public CustomerVO(){};
	
	public CustomerVO(String custId, String name, String address, String tel, ArrayList<CarOrderVO> orderList) {
		super();
		this.custId = custId;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.orderList = orderList;
	}
	
	public CustomerVO(String custId, String name, String address, String tel) {
		super();
		this.custId = custId;
		this.name = name;
		this.address = address;
		this.tel = tel;
	}
	
	public CustomerVO(String custId, String name, String address) {
		super();
		this.custId = custId;
		this.name = name;
		this.address = address;
	}

	// getters and setters
	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public ArrayList<CarOrderVO> getOrderList() {
		return orderList;
	}

	public void setOrderList(ArrayList<CarOrderVO> orderList) {
		this.orderList = orderList;
	}

	@Override
	public String toString() {
		return custId + "\t" + name + "\t" + address + "\t" + tel;
	}	
}
