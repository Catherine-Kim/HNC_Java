package step3.mvc.test;

import java.util.ArrayList;

import step3.mvc.dao.MemberDAO;
import step3.mvc.vo.MemberVO;

public class MemberDaoTest {

	public static void main(String[] args) throws Exception{
		MemberDAO dao = new MemberDAO();
		/*(dao.registerMember
		(new MemberVO("444", "kwjkwj", "Kim Woojeong", "Ω≈√Ã"));*/

		//System.out.println(dao.selectById("222"));
		//dao.updateMember(new MemberVO("444", "kth", "kthkth", "Jefferson City, Missouri"));
		
		ArrayList<MemberVO> returnList = dao.getAllMember();
		for(MemberVO vo : returnList){
			System.out.println(vo);
		}
		
		//dao.deleteMember("bbb");
		/*ArrayList<MemberVO> returnList = dao.selectByAddress("Ω≈√Ã");
		for(MemberVO vo : returnList){
			System.out.println(vo);
		}*/
		//System.out.println(dao.getCountByAddress("Ω≈√Ã"));
	}

}









