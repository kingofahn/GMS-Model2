package command;

import javax.servlet.http.HttpServletRequest;

public class Sentry {
    public static Command cmd = new Command();
    public static void init(HttpServletRequest request) {
        String servletPath=request.getServletPath();
        System.out.println("센트리 0:" + servletPath.substring(0, servletPath.indexOf("."))); // 결과값  - 센트리:/member
        System.out.println("센트리 1:" + servletPath.substring(1, servletPath.indexOf("."))); // 결과값  - 센트리:member
        System.out.println("센트리 2:" + servletPath.substring(2, servletPath.indexOf("."))); // 결과값  - 센트리:ember
        cmd = Commander.order(
                servletPath.substring(1,servletPath.indexOf(".")),
                request.getParameter("action"),
                request.getParameter("page"));
    }
}