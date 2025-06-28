/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loggingdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderLogging {
    private static final Logger logger = LoggerFactory.getLogger(AppenderLogging.class);

    public static void main(String[] args) {
        logger.info("This log goes to both console and file");
        logger.warn("Appenders working: warning logged");
        logger.error("Appenders working: error logged");
    }
}
