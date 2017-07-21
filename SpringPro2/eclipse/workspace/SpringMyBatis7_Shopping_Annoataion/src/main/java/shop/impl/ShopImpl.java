package shop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import item.Item;
import item.catalog.ItemCatalog;
import shop.Shop;

@Service
public class ShopImpl implements Shop{
	// field
	@Autowired
	private ItemCatalog itemCatalog;

	/*// setter
	public void setItemCatalog(ItemCatalog itemCatalog) {
		this.itemCatalog = itemCatalog;
	}*/

	@Override
	public List<Item> getItemList() {
		return itemCatalog.getItemList();
	}

	@Override
	public Item findByPrimaryKey(Item item) {
		return itemCatalog.findByPrimaryKey(item);
	}
}
