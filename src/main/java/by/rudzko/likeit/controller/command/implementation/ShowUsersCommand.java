package by.rudzko.likeit.controller.command.implementation;

import by.rudzko.likeit.controller.Logger;
import by.rudzko.likeit.controller.command.Command;
import by.rudzko.likeit.domain.User;
import by.rudzko.likeit.service.ServiceFactory;
import by.rudzko.likeit.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static by.rudzko.likeit.controller.command.Constant.USERS;

public class ShowUsersCommand implements Command {// не используй слово show, твой класс ведь ничего не покаызвае на самом деле, а только предоставляет информацию
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        List<User> users = null;
        ServiceFactory factory = ServiceFactory.getInstance();
        try {
            users = factory.getUserService().showUsers();
        } catch (ServiceException e) {
            Logger.getLogger().printError(getClass(), e);
        }
        request.setAttribute(USERS, users);
    }
}
