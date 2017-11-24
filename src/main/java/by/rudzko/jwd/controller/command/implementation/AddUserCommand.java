package by.rudzko.jwd.controller.command.implementation;

import by.rudzko.jwd.controller.command.Command;
import by.rudzko.jwd.domain.User;
import by.rudzko.jwd.service.ServiceFactory;
import by.rudzko.jwd.service.exception.ServiceException;
import by.rudzko.jwd.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static by.rudzko.jwd.controller.command.Strings.*;

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
        }
        request.setAttribute(USER, user);
    }
}
