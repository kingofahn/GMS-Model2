package command;
import javax.servlet.http.HttpServletRequest;
import domain.MemberBean;
import service.MemberServiceImpl;

public class RetrieveCommand extends Command {
	MemberBean member;
	public MemberBean getMember() {
		return member;
	}

	public RetrieveCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}

	@Override
	public void execute() {
		member = MemberServiceImpl.getInstance().findById(request.getParameter("uid"));
		request.setAttribute("member", MemberServiceImpl.getInstance().findById(request.getParameter("uid")));
		super.execute();
	}
}