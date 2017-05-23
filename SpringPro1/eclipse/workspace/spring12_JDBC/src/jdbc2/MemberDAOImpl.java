package jdbc2;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class MemberDAOImpl extends JdbcDaoSupport implements MemberDAO{
	// field¿Í setter »èÁ¦

	@Override
	public void register(MemberVO vo) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO member (id, passwd, name, addr) VALUES(");
		sql.append(" ?, ?, ?, ?)");
		
		Object[] param = {vo.getId(), vo.getPassword(), vo.getName(), vo.getAddress()};
		getJdbcTemplate().update(sql.toString(), param);
	}

	
	@Override
	public List<MemberVO> getMemberList() {
		String sql = "SELECT * FROM member";
		
		RowMapper<MemberVO> mapper = new BeanPropertyRowMapper<MemberVO>(MemberVO.class);		
		return getJdbcTemplate().query(sql, mapper);
	}

	@Override
	public MemberVO getSearch(String id) {
		
		String sql = "SELECT * FROM member WHERE id = ?";
		Object[] param = {id};
		
		return getJdbcTemplate().queryForObject(sql, param, new RowMapper<MemberVO>() {

			@Override
			public MemberVO mapRow(ResultSet rs, int arg1) throws SQLException {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("passwd"));
				vo.setAddress(rs.getString("addr"));
				return vo;
			}
		});
	}
}
