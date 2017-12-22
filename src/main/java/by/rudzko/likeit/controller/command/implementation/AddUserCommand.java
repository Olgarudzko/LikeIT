package by.rudzko.likeit.controller.command.implementation;

import by.rudzko.likeit.controller.command.Command;
import by.rudzko.likeit.domain.User;
import by.rudzko.likeit.service.ServiceFactory;
import by.rudzko.likeit.service.exception.ServiceException;
import by.rudzko.likeit.service.validation.InputValidationException;
import by.rudzko.likeit.controller.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static by.rudzko.likeit.controller.command.SessionConstant.*;

public class AddUserCommand implements Command {

    public void execute(HttpServletRequest request, HttpServletResponse response) {
        User user = new User();
        user.setLogin(request.getParameter(LOGIN));
        user.setPassword(request.getParameter(PASSWORD));
        ServiceFactory factory = ServiceFactory.getInstance();

        try {
            user=factory.getUserService().addUser(user);
        } catch (ServiceException e) {
            Logger.getLogger().printError(getClass(), e);
        } catch (InputValidationException e) {
        	Logger.getLogger().printError(getClass(), e);
		}
        request.setAttribute(USER, user);
    }
}
