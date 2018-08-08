package command;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import proxy.PageProxy;
import proxy.Pagination;
import service.MemberServiceImpl;

public class SearchCommand extends Command {
	public SearchCommand(HttpServletRequest request) {
		System.out.println("****    ListCommand 들어옴!!!    ****");
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
        Map<String,Object> paramMap = new HashMap<>();
        String pageNumber = request.getParameter("pageNumber");
        PageProxy pxy = new PageProxy();
        pxy.carryOut((pageNumber==null)? 1: Integer.parseInt(pageNumber));
        Pagination page = pxy.getPagination();
        paramMap.put("beginRow", String.valueOf(page.getBeginRow()));
        paramMap.put("endRow", String.valueOf(page.getEndRow()));
        request.setAttribute("page", page);
        request.setAttribute("list", MemberServiceImpl.getInstance().search(paramMap));
        super.execute();
	}
}	