package service;

import domain.ImageBean;

public interface ImageService {
	public void insert(ImageBean bean);
	public ImageBean retrieve(String id);
}
