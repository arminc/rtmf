package nl.rotterdam.rtmf.guc;

import org.apache.log4j.Logger;
import org.mule.api.MuleContext;
import org.mule.api.MuleException;
import org.mule.api.config.ConfigurationBuilder;
import org.mule.api.config.ConfigurationException;
import org.mule.api.context.MuleContextFactory;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.config.spring.SpringXmlConfigurationBuilder;
import org.mule.context.DefaultMuleContextFactory;

public class StartServerNoMocks {
	private static Logger logger = Logger
			.getLogger(StartServer.class.getName());

	// need to specify this before the StartServer static variable, because this
	// RESOURCES is needed in the constructor
	private static final String[] RESOURCES = { "rtmfguc-config.xml",
			"rtmfguc-zm-config.xml" };

	// the singleton start server class.
	private static StartServerNoMocks server = new StartServerNoMocks();

	private MuleContext context = null;

	/**
	 * Default constructor welke de mule server start.
	 */
	private StartServerNoMocks() {
		this.context = setupServer(RESOURCES);
		try {
			this.context.start();
		} catch (MuleException e) {
			throw new RuntimeException("Failed to start Mule", e);
		}
	}

	/**
	 * This class starts the Mule server using the mule-config.xml configuration
	 * file.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// org.apache.log4j.BasicConfigurator.configure();

		StartServerNoMocks.singleton().startServer();

	}

	private MuleContext setupServer(String[] resources) {
		try {
			MuleContextFactory factory = new DefaultMuleContextFactory();
			ConfigurationBuilder builder = new SpringXmlConfigurationBuilder(
					resources);
			return factory.createMuleContext(builder);
		} catch (ConfigurationException ce) {
			throw new RuntimeException("Failed to create MuleContext for "
					+ resources, ce);
		} catch (InitialisationException e) {
			throw new RuntimeException("Failed to create MuleContext for "
					+ resources, e);
		}
	}

	/**
	 * Methode om mule te starten op basis van de context welke in de
	 * constructor gezet is.
	 */
	public void startServer() {
		logger
				.warn("Ignored startServer() call for Mule, only ONE Mule context is running as singleton.");
	}

	/**
	 * stop de server.
	 */
	public void stopServer() {
		logger
				.warn("Ignored stopServer() call for Mule, only ONE Mule context is running as singleton: it is not stopped unless JVM stops.");
	}

	public static StartServerNoMocks singleton() {
		return server;
	}

}
