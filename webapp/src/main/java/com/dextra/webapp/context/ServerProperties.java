package com.dextra.webapp.context;

import java.io.File;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerProperties {

    private static final String NAME = "webapp.properties";
    private static final ServerProperties SINGLETON = new ServerProperties();
    private final Logger logger = LoggerFactory.getLogger(ServerProperties.class);

    private final Properties properties;

    private ServerProperties() {
        this.properties = new Properties();
        
        try {
        	File f = new File(NAME);
            this.properties.load(this.getClass().getClassLoader().getResourceAsStream(NAME));
        } catch (Exception e) {
        	logger.error("LoadProperties", e);
            throw new RuntimeException(e);
        }
    }

    public static String property(String name) {
        return SINGLETON.properties.getProperty(name);
    }

}
