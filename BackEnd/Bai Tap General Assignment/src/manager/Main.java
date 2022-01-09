package manager;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {
	private static Logger logger = Logger.getLogger(Main.class);
	public static void main(String[] args) {
		PropertyConfigurator.configure("src/log4j.properties");
		logger.info("INFO");
		logger.debug("DEBUG");
		logger.warn("WARN");
		logger.error("ERROR");
		logger.fatal("FATAL");
		MainController.displayMainMenu();
		
	}

}
