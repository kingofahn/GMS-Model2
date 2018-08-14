package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class ModifyCommand extends Command {
	public ModifyCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath()
				.substring(1,
						request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	
	@Override
	public void execute() {
		switch(Domain.valueOf(Receiver.cmd.domain.toUpperCase())) {
		case MEMBER :
			Map<String,Object> map = new HashMap<>();
			map.put("searchWord", ((MemberBean) request.getSession().getAttribute("user")).getUserid());
			map.put("password", request.getParameter("password"));
			map.put("teamid", request.getParameter("teamid"));
			map.put("roll", request.getParameter("roll"));
			MemberServiceImpl.getInstance().modify(map);
			break;
		default : 
			break;
		}
	}
}