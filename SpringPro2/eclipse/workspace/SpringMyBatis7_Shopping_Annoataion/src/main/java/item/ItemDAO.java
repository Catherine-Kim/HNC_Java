package item;

import java.util.List;

public interface ItemDAO {
	List<Item> findAll();
	Item findByPrimaryKey(Item item);
}
