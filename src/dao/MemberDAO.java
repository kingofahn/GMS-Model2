package dao;
import java.util.List;
import java.util.Map;

import domain.MemberBean;

public interface MemberDAO {
	public void insertMember(MemberBean member);
	public List<MemberBean> selectAllmemberList();
	public List<MemberBean> selectList(Map<?,?> param);
	public List<MemberBean> selectMemberBySearchWord(String name);
	public MemberBean selectFindById(String id);
	public int countMember();
	public void updateMemberInformation(MemberBean member);
	public void deleteMemberInformation(MemberBean member);
	public MemberBean login(MemberBean member);
}