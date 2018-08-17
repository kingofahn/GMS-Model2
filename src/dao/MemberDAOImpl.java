package dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import domain.MemberBean;
import template.*;

public class MemberDAOImpl implements MemberDAO {
	private static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {return instance;}
	private MemberDAOImpl() {}
	private QueryTemplate q; HashMap<String, Object> map;
	@Override
	public void insert(MemberBean bean) {
		map = new HashMap<>();
		q = new AddQuery();
		map.put("bean", bean);
		map.put("table", "member");
		q.play(map);
	}
	@Override
	public List<MemberBean> selectSome(Map<?, ?> param) {
		List<MemberBean> list = new ArrayList<>();
		q = new SearchQuery();
		q.play(param);
		for(Object s : q.getList()) {
			list.add((MemberBean)s);
		}
		return list;
	}
	@Override
	public MemberBean selectOne(String id) {
		map = new HashMap<>();
		q= new RetrieveQuery();
		map.put("searchWord", id);
		map.put("table", "member");
		q.play(map);
		return q.getMem();
		
	}
	@Override
	public int count() {
		q = new CountQuery();
		q.play();
		return q.getNumber();
	}
	@Override
	public int count(Map<?, ?> param) {
		q = new CountQuery();
		q.play(param);
		System.out.println("q.getNumber() : " + q.getNumber());
		return q.getNumber();
	}
	
	@Override
	public void update(Map<?, ?> param) {
		q = new UpdateQuery();
		q.play(param);
	}
	@Override
	public void delete(MemberBean bean) {
		map = new HashMap<>();
		q = new RemoveQuery();
		map.put("bean", bean);
		q.play(map);
	}
	@Override
	public MemberBean login(MemberBean bean) {
		map = new HashMap<>();
		q = new LoginQuery();
		map.put("bean", bean);
		q.play(map);
		return q.getMem();
	}
}
