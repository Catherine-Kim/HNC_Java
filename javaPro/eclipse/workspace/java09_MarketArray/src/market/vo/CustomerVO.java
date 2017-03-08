package market.vo;
/*
 * market에서 상품을 구매하는 고객에 대한 정볼르 답고 있는 VO
 */
public class CustomerVO {
	private String name;
	private String address;
	private int ssn;
	
	private ProductVO[] products;

	public CustomerVO(String name, String address, int ssn) {
		this.name = name;
		this.address = address;
		this.ssn = ssn;
	}

	public CustomerVO(int ssn){ //생성자 오버로딩
		this.ssn = ssn; // 왜 했을까??????????????
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

	public void changeAddress(String address) { // 좀더	 정확한 명명을 한다
		this.address = address;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public ProductVO[] getProducts() {
		return products;
	}

	public void buyProducts(ProductVO[] products) { // 
		this.products = products;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + "\t" + address + "\t" + ssn;
	}
}
