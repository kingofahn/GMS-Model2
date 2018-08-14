package dao;

import java.util.HashMap;

import domain.ImageBean;
import template.AddQuery;
import template.QueryTemplate;

public class ImageDAOImpl implements ImageDAO{
	private static ImageDAO instance = new  ImageDAOImpl();
	public static ImageDAO getInstance() {return instance;}
	private ImageDAOImpl() {}
	private QueryTemplate q; HashMap<String, Object> map;

	@Override
	public void insert(ImageBean bean) {
		map = new HashMap<>();
		q = new AddQuery();
		map.put("bean", bean);
		map.put("table", "image");
		q.play(map);
	}

	@Override
	public ImageBean selectOne(String id) {
		map = new HashMap<>();
		return null;
	}
}
