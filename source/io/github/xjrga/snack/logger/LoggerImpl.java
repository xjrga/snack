package io.github.xjrga.snack.logger;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jr
 */
public enum LoggerImpl implements Logger {
	INSTANCE;

	private String regex;
	public List<LogEntry> records;

	LoggerImpl() {

		regex = ".*";
		records = new ArrayList();

	}

	@Override
	public void logProblem( Throwable t ) {

		StringBuilder sb = new StringBuilder();
		sb.append( "\n" );
		sb.append( "StackTrace at " );
		sb.append( LocalTime.now() );
		sb.append( ".\n\n" );
		sb.append( "Message: " );
		sb.append( t.getMessage() );
		sb.append( "\n" );

		StackTraceElement[] stackTrace = t.getStackTrace();

		for ( int i = 0; i < stackTrace.length; i++ ) {

			StackTraceElement ste = t.getStackTrace()[i];
			String callerClassName = ste.getClassName();
			String callerMethodName = ste.getMethodName();
			int callerLineNum = ste.getLineNumber();
			LogEntry r = new LogEntry( i, callerClassName, callerMethodName, callerLineNum );
			records.add( r );

		}

		System.out.println( sb.toString() );
		records.stream().filter( ( LogEntry o ) -> o.getCallerClassPackage().matches( regex ) ).toList()
				.forEach( record -> {

					System.out.println( record );

				} );

	}

	public void filter( String regex ) {

		this.regex = regex;

	}
}
