package api2;

public interface Message {
	String print();
	String message();
	
	// �߰�
	void searchName();
	void searchMemberById(String id);
	void searchAddress(String address);
}
