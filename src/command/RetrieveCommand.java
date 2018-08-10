package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import domain.MemberBean;
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
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("searchWord", request.getParameter("searchWord"));
		request.setAttribute("user",
							MemberServiceImpl.getInstance().retrieve(request.getParameter("searchWord")));
		System.out.println("리트리브커맨드 입력값 : "+MemberServiceImpl.getInstance().retrieve(request.getParameter("searchWord")).getName());
		super.execute();
	}
}