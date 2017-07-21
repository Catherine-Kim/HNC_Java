package item.catalog.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import item.Item;
import item.ItemDAO;
import item.catalog.ItemCatalog;

@Service
public class ItemCatalogImpl implements ItemCatalog{
	// field
	@Autowired
	private ItemDAO itemDao;

	/*// setter
	public void setItemDao(ItemDAO itemDao) {
		this.itemDao = itemDao;
	}*/

	@Override
	public List<Item> getItemList() {
		return itemDao.findAll();
	}

	@Override
	public Item findByPrimaryKey(Item item) {
		return itemDao.findByPrimaryKey(item);
	}
}
