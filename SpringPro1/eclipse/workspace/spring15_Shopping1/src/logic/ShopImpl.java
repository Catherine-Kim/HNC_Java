package logic;

import java.util.List;

public class ShopImpl implements Shop{
	// field
	private ItemCatalog itemCatalog;

	// setter
	public void setItemCatalog(ItemCatalog itemCatalog) {
		this.itemCatalog = itemCatalog;
	}

	@Override
	public List<Item> getItemList() {
		System.out.println("Got in ShopImpl");
		return itemCatalog.getItemList();
	}
}
