package br.com.dextra.estagio2015.comum;


import javax.naming.NamingException;

import com.googlecode.mycontainer.datasource.DataSourceDeployer;
import com.googlecode.mycontainer.ejb.SessionInterceptorDeployer;
import com.googlecode.mycontainer.jta.MyTransactionManagerDeployer;
import com.googlecode.mycontainer.kernel.boot.ContainerBuilder;

public class JPA_DB_Utils {

	private static final String DATA_SOURCE_NAME = "jdbc/DextragiariosDS";

	public static void start() throws NamingException {

		System.setProperty("java.naming.factory.initial",
				"com.googlecode.mycontainer.kernel.naming.MyContainerContextFactory");

		System.setProperty("org.jboss.logging.provider", "slf4j");

		ContainerBuilder builder = new ContainerBuilder();

		builder.deployVMShutdownHook();

		bindContext(builder);
		builder.createDeployer(SessionInterceptorDeployer.class).deploy();
		deployJTA(builder);
		deployDataSource(builder);

	}

	private static void bindContext(ContainerBuilder builder) throws NamingException {
		builder.getContext().bind("java:comp/env/dextragiarios/config", "dextragiarios");
	}

	@SuppressWarnings("unused")
	private static void deployDataSource(ContainerBuilder builder) {
		String driver, url, user, pass, dialect;
		driver = "org.hsqldb.jdbcDriver";
		url = "jdbc:hsqldb:" + System.getProperty("database", "mem:.");
		user = "sa";
		pass = null;
		dialect = "org.hibernate.dialect.HSQLDialect";

		DataSourceDeployer ds = builder.createDeployer(DataSourceDeployer.class);
		ds.setName(DATA_SOURCE_NAME);
		ds.setDriver(driver);
		ds.setUrl(url);
		ds.setUser(user);
		ds.setPass(pass);
		ds.deploy();
	}

	private static void deployJTA(ContainerBuilder builder) {
		MyTransactionManagerDeployer jta = builder.createDeployer(MyTransactionManagerDeployer.class);
		jta.setName("TransactionManager");
		jta.setUserTransactionName("java:comp/UserTransaction");
		jta.deploy();
	}

}
