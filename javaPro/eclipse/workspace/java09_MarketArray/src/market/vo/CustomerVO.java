package market.vo;
/*
 * market���� ��ǰ�� �����ϴ� ���� ���� ������ ��� �ִ� VO
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

	public CustomerVO(int ssn){ //������ �����ε�
		this.ssn = ssn; // �� ������??????????????
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

	public void changeAddress(String address) { // ����	 ��Ȯ�� ����� �Ѵ�
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
