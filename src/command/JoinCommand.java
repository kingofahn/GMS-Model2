package command;

public class JoinCommand extends Command{
	public JoinCommand(String domain, String action, String page) {
		setDomain(domain);
		setAction(action);
		setPage(page);
		execute();
	}
}
