package by.rudzko.jwd.controller.command.implementation;

import by.rudzko.jwd.Logger;
import by.rudzko.jwd.controller.command.Command;
import by.rudzko.jwd.domain.User;
import by.rudzko.jwd.service.ServiceFactory;
import by.rudzko.jwd.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static by.rudzko.jwd.controller.command.Strings.USERS;

public class ShowUsersCommand implements Command {
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        List <User> users = null;
        ServiceFactory factory = ServiceFactory.getInstance();
        try {
            users=factory.getUserService().showUsers();
        } catch (ServiceException e) {
            Logger.getLogger().printError(getClass(), e);
        }
        request.setAttribute(USERS, users);
    }
}
