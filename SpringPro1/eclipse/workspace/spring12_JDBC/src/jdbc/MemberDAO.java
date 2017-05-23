package jdbc;

import java.util.List;

public interface MemberDAO {
	void register(MemberVO vo);
	List<MemberVO> getMemberList();
	MemberVO getSearch(String id);
}
