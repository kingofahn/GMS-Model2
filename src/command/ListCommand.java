package command;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import domain.MemberBean;
import service.MemberServiceImpl;

public class ListCommand extends Command {
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
		int pageNumber = 0;
		int pageSize = 5;
		int blockSize = 5;
		String pageNum = request.getParameter("pageNumber");
		pageNumber=(pageNum == null)? 1 : Integer.parseInt(pageNum);
		int rowCount = MemberServiceImpl.getInstance().memberCount();
		int pageCount = (rowCount % pageSize == 0)? rowCount / pageSize:rowCount / pageSize + 1 ;
		int blockCount = (pageCount % blockSize == 0)? pageCount / blockSize : pageCount / blockSize + 1;
		int beginRow = pageNumber * pageSize - (pageSize - 1);
		int endRow = pageNumber * pageSize;
		int beginPage = pageNumber - ((pageNumber - 1) % blockSize);
		int endPage = ((beginPage + pageSize - 1) < pageCount) ? beginPage + blockSize - 1 : pageCount;
		int prevBlock = beginPage - blockSize;
		int nextBlock = beginPage + blockSize;
		System.out.println("blockCount : " + blockCount);
		System.out.println("pageCount : " + pageCount);
		System.out.println("rowCount : " + rowCount);
		System.out.println("beginPage : " + beginPage); 
		System.out.println("endPage : " + endPage);
		System.out.println("prevBlock : " + prevBlock);
		System.out.println("nextBlock : " + nextBlock);
		boolean existPrev =(prevBlock >= 0) ? true : false ;
		boolean existNext =(nextBlock <= pageCount) ? true : false;
		Map<String, Object> map = new HashMap<>();
		request.setAttribute("count", MemberServiceImpl.getInstance().memberCount());
		request.setAttribute("existPrev", existPrev);
		request.setAttribute("existNext", existNext);
		request.setAttribute("count", rowCount);
		request.setAttribute("beginPage", beginPage);
		request.setAttribute("endPage", endPage);
		map.put("beginRow", beginRow);
		map.put("endRow", endRow);
		List<MemberBean> list = MemberServiceImpl.getInstance().getList(map);
		request.setAttribute("list", list);
		super.execute();
	}
}	
/*		String pageNumber =(request.getParameter("pageNumber")==null)? "1" :request.getParameter("pageNumber");
		int count = MemberServiceImpl.getInstance().memberCount();
		int pageBlock = 5;
		int endPage = (count/pageBlock>pageBlock)? pageBlock : (count%pageBlock==0)? pageBlock/5: pageBlock/5+1;
		System.out.println("pageNumber : " + pageNumber);
		System.out.println("count : " + count);
		System.out.println("endPage : " + endPage);
		request.setAttribute("beginPage",1);// 해쉬맵의 구조라서 숫자값을 먹게한다.
		request.setAttribute("endPage",endPage);
		Map<String,Object> param = new HashMap<>();
		int beginRow=(pageNumber=="1")? 1: 1+(Integer.parseInt(pageNumber)-1)*pageBlock;
		int endRow = (pageNumber=="1")? 5 : Integer.parseInt(pageNumber)*pageBlock;
		
		int prevBlock = 0;
		int nextBlock = 0;
		int pageCount = 0;
		
		boolean existPrev=false;
		if(prevBlock>=0) {
			existPrev = true;
		}
		boolean existNext=false;
		if(nextBlock<=pageCount) {
			existNext = true;
		}
		
		System.out.println("beginRow : " + beginRow);
		System.out.println("endRow : " + endRow);
		param.put("beginRow", beginRow);
		param.put("endRow", endRow);
		request.setAttribute("count",MemberServiceImpl.getInstance().memberCount());// 해쉬맵의 구조라서 숫자값을 먹게한다.
		request.setAttribute("getList", MemberServiceImpl.getInstance().getList(param));
		request.setAttribute("memberList", MemberServiceImpl.getInstance().listMember());
		request.setAttribute("existNext", existNext);
		request.setAttribute("existPrev", existPrev);
		super.execute();
		System.out.println("**** ListCommand에 execute 실행함!!! ****");*/
		
/*		Map<String,Object> param = new HashMap<>();
		int rowCount = MemberServiceImpl.getInstance().memberCount();
		int beginRow =1;
		int endRow =5;
		int pageNumber =0;
		int beginPage = 0;
		int endPage =0;
		int pageSize = 5;
		int blockSize = 5;
		
		System.out.println("rowCount : " + rowCount);
		param.put("beginRow", beginRow);
		param.put("endRow", endRow);
		request.setAttribute("getList", MemberServiceImpl.getInstance().getList(param));
		String pageNum = request.getParameter("pageNumber");
		
		beginRow = pageNumber*pageSize -(pageSize-1);
		endRow = pageNumber*pageSize;
		int prevBlock = beginPage - blockSize;
		int nextBlock = beginPage + blockSize;
		if(pageNum==null) {
			pageNumber = 1;
		} else {
			pageNumber = Integer.parseInt(pageNum);
			endPage = (rowCount>(pageSize*blockSize))? blockSize : (rowCount%pageSize==0)? rowCount/pageSize: rowCount/pageSize+1;
			beginRow = 1+ ((pageNumber-1)*pageSize);
			endRow = beginRow +pageSize ;
		}
		request.setAttribute("beginPage",beginRow);// 해쉬맵의 구조라서 숫자값을 먹게한다.
		request.setAttribute("endPage", endPage);
		request.setAttribute("memberList", MemberServiceImpl.getInstance().listMember());
		super.execute();
		System.out.println("**** ListCommand에 execute 실행함!!! ****");*/
