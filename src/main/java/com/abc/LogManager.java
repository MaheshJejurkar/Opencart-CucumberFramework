package com.abc;

import org.apache.logging.log4j.Logger;

public class LogManager {
    public static Logger logger;

    private LogManager() {
    }

    public static Logger getLogger() {
        logger = org.apache.logging.log4j.LogManager.getLogger(LogManager.class);
        return logger;
    }
}
