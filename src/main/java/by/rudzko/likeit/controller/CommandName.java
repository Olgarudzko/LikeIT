package by.rudzko.likeit.controller;

public enum CommandName {
	ADDUSER(PageName.USER_PAGE), FINDUSER(PageName.USER_PAGE), SHOWUSERS(PageName.LIST_PAGE);
	private String jsp;

	CommandName(String jsp) {
		this.jsp = jsp;
	}

	public String getJsp() {
		return jsp;
	}

	private static class PageName {
		private static final String USER_PAGE = "user.jsp";
		private static final String LIST_PAGE = "list.jsp";
	}
}
