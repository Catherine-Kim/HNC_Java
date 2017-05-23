package dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import logic.Item;

public class ItemDaoImpl extends JdbcDaoSupport implements ItemDAO{
	private static final String SELECT_ALL = "SELECT * FROM item";

	@Override
	public List<Item> findAll() {
		System.out.println("Got in ItemDaoImpl");
		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		List<Item> list = getJdbcTemplate().query(SELECT_ALL, mapper);
		System.out.println("list from ItemDAOImpl :: " + list);
		return list;
	}
}
