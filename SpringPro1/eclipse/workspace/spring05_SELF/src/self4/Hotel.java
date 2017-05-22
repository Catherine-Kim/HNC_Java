package self4;

public class Hotel implements Residence{
	// field
	private String hotelName;
	private int cost;

	// constructor
	public Hotel() { }

	// getter & setter
	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	@Override
	public void reside() {
		System.out.println("Reside - Hotel :: " + hotelName + "(" + cost + ")");		
	}
}
