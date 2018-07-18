package controller;
import domain.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;
import command.Sentry;
import dao.MemberDAOImpl;
import domain.MemberBean;
import service.MemberServiceImpl;

import enums.Action;

@WebServlet("/member.do")  // URL Mapping
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberController Entered!!");
		List<MemberBean> lst = null;
		MemberBean mem = null;
		/*String page = request.getParameter("page");
		String action = request.getParameter("action");*/
		Sentry.init(request);
	    System.out.println("액션:"+Sentry.cmd.getAction().toUpperCase());  // 결과 값 액션:move
		switch(Action.valueOf(Sentry.cmd.getAction().toUpperCase())) {
	    case MOVE : 
	            try {
	                Carrier.send(request, response);
		            } catch (Exception e) {e.printStackTrace();} 
	            break; 
		case JOIN : 
			mem = new MemberBean();
			mem.setName(request.getParameter("name"));
			mem.setPassword(request.getParameter("password"));
			mem.setSsn(request.getParameter("ssn"));
			mem.setUserId(request.getParameter("userid"));
			MemberServiceImpl.getInstance().createMember(mem);
			response.sendRedirect(request.getContextPath()+"/member.do?action=move&page=userLoginForm");
			// getContextPath -> 도메인
			// sendRedirect 다시 나한테 돌아와  
						
			break;
		case LIST :
			lst = MemberServiceImpl.getInstance().listMember();
			for(MemberBean m : lst){
				System.out.println(m);
			}; 
			break;
		case SEARCH :
			lst = MemberServiceImpl.getInstance()
								   .findMemberByTeamName(request.getParameter("teamid"));
			for(MemberBean m : lst){
				System.out.println(m);
			}; 
			break;
		case RETRIEVE :
			mem = MemberServiceImpl.getInstance().findById(request.getParameter("uid"));
					mem.getName();
					mem.getTeamId();
					mem.getUserId();
					mem.getAge();
					mem.getRoll();
					mem.getSsn();
			break;
		case COUNT :
			System.out.println(MemberDAOImpl.getInstance().countMember());
			break;
		case UPDATE :
			mem = new MemberBean();
			mem.setUserId(request.getParameter("userid"));
			mem.setPassword(request.getParameter("password"));
			mem.setPassword(request.getParameter("newpassword"));
			MemberServiceImpl.getInstance().updateMemberInformation(mem);
			response.sendRedirect(request.getContextPath());
			break;
		case DELETE :
			mem = new MemberBean();
			mem.setUserId(request.getParameter("userid"));
			mem.setPassword(request.getParameter("password"));
			MemberServiceImpl.getInstance().deleteMemberInformation(mem);
			response.sendRedirect(request.getContextPath());
			
			break;
		case LOGIN :
			mem = new MemberBean();
			mem.setUserId(request.getParameter("userid"));
			mem.setPassword(request.getParameter("password"));
			response.sendRedirect(request.getContextPath());
			break; 
		default : 
			break;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
