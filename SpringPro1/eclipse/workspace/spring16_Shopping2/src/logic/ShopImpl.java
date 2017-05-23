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
		return itemCatalog.getItemList();
	}

	@Override
	public Item findByPrimaryKey(int itemId) {
		return itemCatalog.findByPrimaryKey(itemId);
	}
}
