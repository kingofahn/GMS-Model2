package command;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import enums.Domain;
import proxy.PageProxy;
import proxy.Pagination;
import service.MemberServiceImpl;

public class SearchCommand extends Command {
	public SearchCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
        Map<String,Object> map = new HashMap<>();
        String pageNumber = request.getParameter("pageNumber");
        PageProxy pxy = new PageProxy();
        map.put("pageNumber", (pageNumber==null)? 1: Integer.parseInt(pageNumber));
        map.put("searchOption", request.getParameter("searchOption"));
        map.put("searchWord", request.getParameter("searchWord"));
        map.put("rowCount", (request.getParameter("searchOption")==null)? MemberServiceImpl.getInstance().count() : MemberServiceImpl.getInstance().count(map));
        pxy.carryOut(map);
        Pagination page = pxy.getPagination();
        map.put("table", Domain.MEMBER);
        map.put("beginRow", String.valueOf(page.getBeginRow()));
        map.put("endRow", String.valueOf(page.getEndRow()));
        map.put("rowCount", String.valueOf(page.getRowCount()));
        request.setAttribute("page", page);
        request.setAttribute("list", MemberServiceImpl.getInstance().search(map));
        super.execute();
	}
}	