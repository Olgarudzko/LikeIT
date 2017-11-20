package by.rudzko.jwd.controller.command.implementation;

import by.rudzko.jwd.controller.command.Command;
import by.rudzko.jwd.domain.entity.User;
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
            e.printStackTrace();
        }
        if (users.isEmpty()) { users = null; }
        request.setAttribute(USERS, users);
    }
}
