package by.rudzko.likeit.controller;

import by.rudzko.likeit.controller.command.Command;
import by.rudzko.likeit.service.ServiceInitializer;
import by.rudzko.likeit.service.exception.ServiceInitializationException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {
    
	private static final long serialVersionUID = 3707968871754128175L;
	private static final String JSP_PACKAGE = "/WEB-INF/jsp/";
	private static final String ERROR_JSP = "error.jsp";
	private static final String COMMAND = "command";
    private boolean driverError = false;

    public FrontController() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	 try {
 			ServiceInitializer.initialize();
 		} catch (ServiceInitializationException e) {
             Logger.getLogger().printError(getClass(), e);
             driverError=true;
 		}
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!driverError) {
        	String strCommand = request.getParameter(COMMAND);
	        CommandProvider provider = CommandProvider.getProvider();
	        Command command = provider.getCommand(strCommand);
	        command.execute(request, response);
	        RequestDispatcher disp = request.getRequestDispatcher(JSP_PACKAGE.concat(provider.getJsp(strCommand)));
	        disp.forward(request, response);
        } else {
        	request.getRequestDispatcher(JSP_PACKAGE.concat(ERROR_JSP)).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
