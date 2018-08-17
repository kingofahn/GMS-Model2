package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.ImageServiceImpl;
import service.MemberServiceImpl;

public class ModifyCommand extends Command {
	public ModifyCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath()
				.substring(1,
						request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	
	@Override
	public void execute() {
		switch(Domain.valueOf(Receiver.cmd.domain.toUpperCase())) {
		case MEMBER :
			Map<String,Object> map = new HashMap<>();
			MemberBean mem =  (MemberBean) request.getSession().getAttribute("user");
			request.setAttribute("image", ImageServiceImpl.getInstance().retrieve(mem.getUserid()));
			mem.setPassword(request.getParameter("password"));
			mem.setTeamid(request.getParameter("teamid"));
			mem.setRoll(request.getParameter("roll"));
			map.put("user", mem);
			MemberServiceImpl.getInstance().modify(map);
			break;
		default : 
			break;
		}
	}
}