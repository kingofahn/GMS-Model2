package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sentry {
    public static Command cmd = new Command();
    public static void init(HttpServletRequest request, HttpServletResponse response) {
    	System.out.println("%%%% Sentry init사용됨 %%%%");
        cmd = Commander.order(request);
    }
}