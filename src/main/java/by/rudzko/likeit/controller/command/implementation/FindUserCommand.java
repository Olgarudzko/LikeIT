package by.rudzko.likeit.controller.command.implementation;

import by.rudzko.likeit.controller.Logger;
import by.rudzko.likeit.controller.command.Command;
import by.rudzko.likeit.domain.User;
import by.rudzko.likeit.service.ServiceFactory;
import by.rudzko.likeit.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static by.rudzko.likeit.controller.command.Constant.*;

public class FindUserCommand implements Command {

    public void execute(HttpServletRequest request, HttpServletResponse response) {

        User user = new User();
        user.setLogin(request.getParameter(LOGIN));
        user.setPassword(request.getParameter(PASSWORD));
        ServiceFactory factory = ServiceFactory.getInstance();

        try {
            user = factory.getUserService().findUser(user);
        } catch (ServiceException e) {
            Logger.getLogger().printError(getClass(), e);// логгер беретсядля каждого класса отдельно
            // не надо писать свои логгер для каждого класса
            // а пользователю что будем отправлять в случае исключения? 
        }
        request.setAttribute(USER, user);
    }

}
