package com.abc.utilities;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class BaseTest {

    /**
     * Generates a unique email address with random string and timestamp
     * Format: random5chars.random5chars+timestamp@gmail.com
     * @return unique email address
     */
    public static String getEmailAddress() {
        long timestamp = System.currentTimeMillis();
        String generatedEmail = RandomStringUtils.randomAlphabetic(5).toLowerCase() + "." +
                               RandomStringUtils.randomAlphabetic(5).toLowerCase() +
                               "+" + timestamp + "@gmail.com";
        return generatedEmail;
    }

}
