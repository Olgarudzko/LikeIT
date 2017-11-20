package by.rudzko.jwd.controller;

public enum CommandName {
	ADDUSER(Constants.USER_PAGE), FINDUSER(Constants.USER_PAGE), SHOWUSERS(Constants.LIST_PAGE);
	private String jsp;

	CommandName(String jsp) {
		this.jsp = jsp;
	}

	public String getJsp() {
		return jsp;
	}

	private static class Constants {
		private static final String USER_PAGE = "user.jsp";
		private static final String LIST_PAGE = "list.jsp";
	}
}
