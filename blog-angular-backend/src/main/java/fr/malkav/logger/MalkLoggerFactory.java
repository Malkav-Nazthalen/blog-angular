package fr.malkav.logger;

import org.slf4j.LoggerFactory;

public class MalkLoggerFactory {

    private static final MalkLoggerFactory instance = new MalkLoggerFactory();

    private MalkLoggerFactory() {
        super();
    }

    public static <T> IMalkLogger getLogger(Class<T> aClass) {
        return instance.getLog(aClass);
    }

    private <T> IMalkLogger getLog(Class<T> aClass) {
        return new MalkLogger(LoggerFactory.getLogger(aClass.getName()));
    }

}
