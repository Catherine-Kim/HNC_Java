package shop;

import java.util.List;

import item.Item;

public interface Shop {
	List<Item> getItemList();
	Item findByPrimaryKey(Item item);
}
