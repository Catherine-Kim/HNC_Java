package item.catalog.impl;

import java.util.List;

import item.Item;
import item.ItemDAO;
import item.catalog.ItemCatalog;


public class ItemCatalogImpl implements ItemCatalog{
	// field
	private ItemDAO itemDao;

	// setter
	public void setItemDao(ItemDAO itemDao) {
		this.itemDao = itemDao;
	}

	@Override
	public List<Item> getItemList() {
		return itemDao.findAll();
	}

	@Override
	public Item findByPrimaryKey(Item item) {
		return itemDao.findByPrimaryKey(item);
	}
}
