package command;

import javax.servlet.http.HttpServletRequest;

import domain.ImageBean;
import domain.MemberBean;
import service.ImageService;
import service.ImageServiceImpl;
import service.MemberServiceImpl;

public class RetrieveCommand extends Command {
	public RetrieveCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}

	@Override
	public void execute() {
		if(request.getParameter("searchWord")!=null) {
			request.setAttribute("user", MemberServiceImpl.getInstance().retrieve(request.getParameter("searchWord")));
			request.setAttribute("image", ImageServiceImpl.getInstance().retrieve(request.getParameter("searchWord")));
		} else {
			request.setAttribute("user", MemberServiceImpl.getInstance().retrieve(request.getParameter("userid")));
			request.setAttribute("image", ImageServiceImpl.getInstance().retrieve(request.getParameter("userid")));
		}
	super.execute();
	}
}