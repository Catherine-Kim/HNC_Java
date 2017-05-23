package logic;

import java.util.List;

import dao.ItemDAO;

public class ItemCatalogImpl implements ItemCatalog{
	// field
	private ItemDAO itemDao;

	// setter
	public void setItemDao(ItemDAO itemDao) {
		this.itemDao = itemDao;
	}

	@Override
	public List<Item> getItemList() {
		System.out.println("Got in ItemCatalogImpl");
		return itemDao.findAll();
	}
}
