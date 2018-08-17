package dao;
import java.util.List;
import java.util.Map;

import domain.MemberBean;

public interface MemberDAO {
	public void insert(MemberBean bean);
	public List<MemberBean> selectSome(Map<?,?> param);
	public MemberBean selectOne(String id);
	public int count();
	public int count(Map<?,?> param);
	public void update(Map<?,?> param);
	public void delete(MemberBean bean);
	public MemberBean login(MemberBean bean);
}