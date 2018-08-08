package service;
import java.util.List;
import java.util.Map;

import domain.MemberBean;

public interface MemberService {
	public void create(MemberBean bean);
	public List<MemberBean> search(Map<?,?> param);
	public MemberBean retrieve(String id);
	public int count();
	public void modify(Map<?,?> param);
	public void remove(MemberBean bean);
	public boolean login(MemberBean bean);
}