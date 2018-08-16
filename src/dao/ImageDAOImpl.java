package dao;

import java.util.HashMap;

import domain.ImageBean;
import template.AddQuery;
import template.QueryTemplate;
import template.RetrieveQuery;

public class ImageDAOImpl implements ImageDAO{
	private static ImageDAO instance = new  ImageDAOImpl();
	public static ImageDAO getInstance() {return instance;}
	private ImageDAOImpl() {}
	private QueryTemplate q; HashMap<String, Object> map;

	@Override
	public void insert(ImageBean bean) {
		map = new HashMap<>();
		q = new AddQuery();
		map.put("img", bean);
		map.put("table", "image");
		q.play(map);
	}

	@Override
	public ImageBean selectOne(String id) {
		map = new HashMap<>();
		q = new RetrieveQuery();
		map.put("userid", id);
		map.put("table", "image");
		q.play(map);
		return q.getImg();
	}
}
