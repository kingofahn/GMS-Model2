package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import service.MemberServiceImpl;
public class CountCommand extends Command {
	public CountCommand(HttpServletRequest request) {
		System.out.println("CountCommand 들어옴!!!");
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	
	public void execute() {
		Map<String,Object> map = new HashMap<>();
		System.out.println("Command에서 searchOption : " + request.getParameter("seqrchOption"));
		if(request.getParameter("searchOption")!=null) {
	        map.put("searchOption", request.getParameter("searchOption"));
	        map.put("searchWord", request.getParameter("searchWord"));
	        request.setAttribute("count",MemberServiceImpl.getInstance().count(map));
		} else {
			request.setAttribute("count",MemberServiceImpl.getInstance().count());
		}
		super.execute();
	}
}
