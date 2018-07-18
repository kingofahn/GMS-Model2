package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Carrier {
	public static void send(HttpServletRequest request, 
			HttpServletResponse response)
			throws Exception {
		System.out.println("뷰:" + Sentry.cmd.getView());  // 결과 값 : /WEB-INF/view/member/joinForm.jsp
		request
		.getRequestDispatcher(Sentry.cmd.getView())
		.forward(request, response);
	}
}
