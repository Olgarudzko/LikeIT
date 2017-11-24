package by.rudzko.jwd.service;

import by.rudzko.jwd.service.UserService;
import by.rudzko.jwd.service.implementation.UserServiceImpl;

public final class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private final by.rudzko.jwd.service.UserService userService = new UserServiceImpl();

    private ServiceFactory() {
    }

    public UserService getUserService() {
        return userService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

}