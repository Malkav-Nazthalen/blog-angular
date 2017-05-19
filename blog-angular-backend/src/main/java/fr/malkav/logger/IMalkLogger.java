package fr.malkav.logger;

public interface IMalkLogger {

	void warn(String message);

	void warn(String message, Object... params);

	void info(String message);

	void info(String message, Object... params);

	void error(String message);

	void error(String message, Object... params);

	void error(Exception exception);

	void debug(String message);

	void debug(String message, Object... params);

	void debug(Exception exception);

	void trace(String message);

	void trace(String message, Object... params);

	void trace(Exception exception);
}
