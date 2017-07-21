package persistence;

import java.util.Map;


public class SqlServiceImpl implements SqlService{
	// field
	private Map<String, String> sqlMap;
	
	public void setSqlMap(Map<String, String> sqlMap) {
		this.sqlMap = sqlMap;
	}

	@Override
	public String getSql(String key) throws Exception {
		String sql = sqlMap.get(key);
		if(sql == null) throw new Exception(); 	// �� �� ����� ���� Exception �Ͷ߸��� ��
		else return sql;
	}
}
