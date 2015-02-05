package com.dextra.injectit.booter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.dextra.injectit.database.MockDatabase;

@WebListener
public class ContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		MockDatabase.execute();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// Does nothing
	}
}