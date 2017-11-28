package by.rudzko.likeit.service;

import by.rudzko.likeit.dao.ConnectionCreator;
import by.rudzko.likeit.dao.exception.DAOException;
import by.rudzko.likeit.service.exception.ServiceException;

public class ConnectorInitializer {

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
