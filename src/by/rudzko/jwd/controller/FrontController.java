package by.rudzko.jwd.controller;

import by.rudzko.jwd.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {
    private static final String JSP_PACKAGE = "/WEB-INF/jsp/";
    private static final String COMMAND = "command";
    private static final long serialVersionUID = 1L;

    public FrontController() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strCommand = request.getParameter(COMMAND);
        CommandProvider provider = CommandProvider.getProvider();
        Command command = provider.getCommand(strCommand);
        command.execute(request, response);
        RequestDispatcher disp = request.getRequestDispatcher(JSP_PACKAGE.concat(provider.getJsp(strCommand)));
        disp.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
