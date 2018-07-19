package command;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import domain.MemberBean;
import service.MemberServiceImpl;

public class ListCommand extends Command {
	List<MemberBean> members;
	public List<MemberBean> getMembers() {
		return members;
	}

	public ListCommand(HttpServletRequest request) {
		System.out.println("****    ListCommand 들어옴!!!    ****");
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		this.members = MemberServiceImpl.getInstance().listMember();
		/*request.setAttribute("list", MemberServiceImpl.getInstance().listMember());*/
		super.execute();
		System.out.println("**** ListCommand에 execute 실행함!!! ****");
	}
}