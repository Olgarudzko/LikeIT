package by.rudzko.jwd.controller.command.implementation;

import by.rudzko.jwd.controller.command.Command;
import by.rudzko.jwd.domain.entity.User;
import by.rudzko.jwd.service.ServiceFactory;
import by.rudzko.jwd.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static by.rudzko.jwd.controller.command.Strings.*;

public class FindUserCommand implements Command{

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		User user = new User();
		user.setLogin(request.getParameter(LOGIN));
		user.setPassword(request.getParameter(PASSWORD));
		ServiceFactory factory = ServiceFactory.getInstance();

		try {
			user=factory.getUserService().findUser(user);
		} catch (ServiceException e) {
			user=null;
			e.printStackTrace();
		}
		request.setAttribute(USER, user);
	}

}
