package fr.malkav.logger;

import org.slf4j.Logger;

class MalkLogger implements IMalkLogger {

	private final Logger log;

	private static final String START_ERROR_MESSAGE = "Un erreur s'est produite : ";

	MalkLogger(Logger logger) {
		log = logger;
	}

	@Override
	public void warn(String message) {
		log.warn(message);
	}

	@Override
	public void info(String message) {
		log.info(message);
	}

	@Override
	public void error(String message) {
		log.error(message);
	}

	@Override
	public void error(Exception exception) {
		log.error(START_ERROR_MESSAGE, exception);
	}

	@Override
	public void debug(String message) {
		log.debug(message);
	}

	@Override
	public void trace(String message) {
		log.trace(message);
	}

	@Override
	public void warn(String message, Object... params) {
		log.warn(message, params);
	}

	@Override
	public void info(String message, Object... params) {
		log.info(message, params);
	}

	@Override
	public void error(String message, Object... params) {
		log.error(message, params);
	}

	@Override
	public void debug(String message, Object... params) {
		log.debug(message, params);
	}

	@Override
	public void debug(Exception exception) {
		log.debug(START_ERROR_MESSAGE, exception);
	}

	@Override
	public void trace(String message, Object... params) {
		log.trace(message, params);
	}

	@Override
	public void trace(Exception exception) {
		log.trace(START_ERROR_MESSAGE, exception);
	}

}
