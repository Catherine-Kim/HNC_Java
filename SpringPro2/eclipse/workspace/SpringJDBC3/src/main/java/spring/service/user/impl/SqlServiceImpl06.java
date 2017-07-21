package spring.service.user.impl;

import java.util.Map;

import spring.service.user.SqlService;

public class SqlServiceImpl06 implements SqlService{
	// field
	private Map<String, String> sqlMap;
	
	public void setSqlMap(Map<String, String> sqlMap) {
		this.sqlMap = sqlMap;
	}

	@Override
	public String getSql(String key) throws Exception {
		String sql = sqlMap.get(key);
		if(sql == null) throw new Exception(); 	// 이 때 사용자 정의 Exception 터뜨리면 됨
		else return sql;
	}
}
