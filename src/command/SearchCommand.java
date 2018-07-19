package command;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import domain.MemberBean;
import service.MemberServiceImpl;

public class SearchCommand extends Command {
	List<MemberBean> members;
	public List<MemberBean> getMembers() {
		return members;
	}

	public SearchCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}

	@Override
	public void execute() {
		this.members = MemberServiceImpl.getInstance().findMemberByTeamName(request.getParameter("teamid"));
		super.execute();
	}
}