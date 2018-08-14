package service;

import dao.ImageDAOImpl;
import domain.ImageBean;

public class ImageServiceImpl implements ImageService {
	private static ImageService instance = new ImageServiceImpl();
	public static ImageService getInstance() {return instance;}
	private ImageServiceImpl() {}

	@Override
	public void insert(ImageBean bean) {
		ImageDAOImpl.getInstance().insert(bean);
	}

	@Override
	public ImageBean retrieve(String id) {
		return ImageDAOImpl.getInstance().selectOne(id);
	}

}
