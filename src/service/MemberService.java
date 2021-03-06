package service;
import java.util.List;
import java.util.Map;

import domain.MemberBean;

public interface MemberService {
	public void createMember(MemberBean member);
	public List<MemberBean> listMember();
	public List<MemberBean> getList(Map<?,?> param);
	public List<MemberBean> findMemberByTeamName(String name);
	public MemberBean findById(String id);
	public int memberCount();
	public void updateMemberInformation(MemberBean member);
	public void deleteMemberInformation(MemberBean member);
	public boolean login(MemberBean member);
}