package command;

import javax.servlet.http.HttpServletRequest;

import domain.ImageBean;
import domain.MemberBean;
import service.ImageService;
import service.ImageServiceImpl;
import service.MemberServiceImpl;

public class RetrieveCommand extends Command {
	ImageBean bean =null;
	MemberBean user = null;
	public RetrieveCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}

	@Override
	public void execute() {
		bean = new ImageBean();
		user = MemberServiceImpl.getInstance().retrieve(request.getParameter("searchWord"));
		request.setAttribute("user",user);
		request.setAttribute("image", ImageServiceImpl.getInstance().retrieve(request.getParameter("searchWord")));
		bean.setUserid(user.getUserid());
		;
		super.execute();
	}
}