package dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import logic.Item;

public class ItemDaoImpl extends JdbcDaoSupport implements ItemDAO{
	private static final String SELECT_ALL = "SELECT * FROM item";
	// field Ãß°¡
	private static final String SELECT_BY_PRIMARY_KEY = "SELECT * FROM item WHERE item_id=?";

	@Override
	public List<Item> findAll() {
		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		return getJdbcTemplate().query(SELECT_ALL, mapper);
	}

	@Override
	public Item findByPrimaryKey(int itemId) {
		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		return getJdbcTemplate().queryForObject(SELECT_BY_PRIMARY_KEY, new Object[]{itemId}, mapper);
	} 
}
