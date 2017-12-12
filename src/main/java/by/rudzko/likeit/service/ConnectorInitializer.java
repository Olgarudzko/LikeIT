package by.rudzko.likeit.service;

import by.rudzko.likeit.dao.ConnectionCreator;
import by.rudzko.likeit.dao.exception.DAOException;
import by.rudzko.likeit.service.exception.ServiceException;

public class ConnectorInitializer {// откуда этот код появился в сервисах?
    // ты навязываешь слою сервисов инициализировать что-то, что принадлежить только слою дао
    // твоя фабрика в дао больше знает о коннекторах, чем сервичы

    public static void initializeConnector() throws ServiceException {
        try {
            ConnectionCreator.initialize();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    private ConnectorInitializer() {
    }
}
