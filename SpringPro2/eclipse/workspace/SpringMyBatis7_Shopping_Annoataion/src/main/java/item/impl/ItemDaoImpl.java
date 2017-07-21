package item.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import item.Item;
import item.ItemDAO;

@Repository
public class ItemDaoImpl implements ItemDAO{
	/*private static final String SELECT_ALL = "SELECT * FROM item";
	// field 추가
	private static final String SELECT_BY_PRIMARY_KEY = 
													"SELECT * FROM item WHERE item_id=?";*/
	
	/*@Override
	public List<Item> findAll() {
		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		return getJdbcTemplate().query(SELECT_ALL, mapper);
	}

	@Override
	public Item findByPrimaryKey(int itemId) {
		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		return getJdbcTemplate().queryForObject(SELECT_BY_PRIMARY_KEY, 
															new Object[]{itemId}, mapper);
	} */
	
	// field 추가
	@Autowired
	private SqlSession sqlSession;

	/*// setter 추가
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}*/

	@Override
	public List<Item> findAll() {
		return sqlSession.selectList("ItemSQL.selectAll");
	}

	@Override
	public Item findByPrimaryKey(Item item) {
		return sqlSession.selectOne("ItemSQL.selectByPK", item);
	}
}
