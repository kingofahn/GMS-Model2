package command;
import javax.servlet.http.HttpServletRequest;
import enums.Action;

public class Commander {
	public static Command order(HttpServletRequest request){
			Command cmd =null;
			switch(Action.valueOf(request.getParameter("action").toUpperCase())) {
			case MOVE : 
				System.out.println("----Commander에 Case의  무브진입----");
				cmd = new MoveCommand(request);
				break;
			case JOIN : 
				System.out.println("----Commander에 Case의  조인진입----");
				cmd = new CreateCommand(request);
				break;
			case DELETE : 
				System.out.println("----Commander에 Case의  딜리트진입----");
				cmd = new DeleteCommand(request);
				break;
			case UPDATE : 
				System.out.println("----Commander에 Case의  업데이트진입----");
				cmd = new UpdateCommand(request);
				break;
			case LOGIN : 
				System.out.println("----Commander에 Case의  로그인진입----");
				cmd = new LoginCommand(request);
				break;
			case LIST : 
				System.out.println("----Commander에 Case의 LIST 진입----");
				cmd = new ListCommand(request);
				break;
			case RETRIEVE : 
				System.out.println("----Commander에 Case의  RETRIEVE 진입----");
				cmd = new RetrieveCommand(request);
				break;
			case SEARCH : 
				System.out.println("----Commander에 Case의  SEARCH 진입----");
				cmd = new SearchCommand(request);
				break;
			case COUNT : 
				System.out.println("----Commander에 Case의  COUNT 진입----");
				cmd = new CountCommand(request);
				break;
			default:
				break;
			}
			return cmd;
	}
}
