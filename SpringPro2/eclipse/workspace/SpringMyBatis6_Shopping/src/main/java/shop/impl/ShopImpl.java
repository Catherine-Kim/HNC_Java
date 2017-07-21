package shop.impl;

import java.util.List;

import item.Item;
import item.catalog.ItemCatalog;
import shop.Shop;

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
	public Item findByPrimaryKey(Item item) {
		return itemCatalog.findByPrimaryKey(item);
	}
}
