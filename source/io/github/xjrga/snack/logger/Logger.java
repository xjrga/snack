package io.github.xjrga.snack.logger;

/**
 * @author jr
 */
public interface Logger {

	// void logRecord( String message );

	void logProblem( Throwable problem );

}
