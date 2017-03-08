package team.step1.marketVO;

public class KostaMarketVO {
	// Fields
	String marketName;
	int totalSales;
	
	// Constructors
	public KostaMarketVO(){};
	
	public KostaMarketVO(String marketName, int totalSales){
		this.marketName = marketName;
		this.totalSales = totalSales;
	}
	
	// Getters
	public String getMarketName(){
		return this.marketName;
	}

	public int getTotalSales(){
		return this.totalSales;
	}

	// Setters
	public void setMarketName(String marketName){
		this.marketName = marketName;
	}
	
	public void setTotalSales(int totalSales){
		this.totalSales = totalSales;
	}
	
}


