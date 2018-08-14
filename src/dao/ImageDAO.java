package dao;

import domain.ImageBean;

public interface ImageDAO {
	public void insert(ImageBean bean);
	public ImageBean selectOne(String id);
}
