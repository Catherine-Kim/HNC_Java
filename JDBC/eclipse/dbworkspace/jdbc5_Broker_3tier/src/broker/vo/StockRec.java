package broker.vo;

import java.io.Serializable;

public class StockRec implements Serializable{
	private String symbol;
	private float price;
	
	// constructors
	public StockRec(){};
	
	public StockRec(String symbol, float price) {
		super();
		this.symbol = symbol;
		this.price = price;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return symbol + "\t" + price;
	}
}
