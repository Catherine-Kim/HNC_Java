package item.catalog;

import java.util.List;

import item.Item;

// Service Layer Bean Interface
public interface ItemCatalog {
	List<Item> getItemList();
	Item findByPrimaryKey(Item item);
}
