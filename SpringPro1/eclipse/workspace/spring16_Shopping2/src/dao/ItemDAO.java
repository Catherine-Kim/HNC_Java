package dao;

import java.util.List;

import logic.Item;

public interface ItemDAO {
	List<Item> findAll();
	Item findByPrimaryKey(int itemId);
}
