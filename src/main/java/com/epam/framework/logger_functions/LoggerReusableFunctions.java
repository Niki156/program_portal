package com.epam.framework.logger_functions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerReusableFunctions {
	
	private LoggerReusableFunctions() {}
	
	private static Logger logger = LogManager.getLogger(LoggerReusableFunctions.class);

	public static void logInfo(String infoMessage)
	{
		logger.info(infoMessage);
	}
	public static void logError(String errorMessage)
	{
		logger.error(errorMessage);
	}
	public static void logWarn(String warningMessage)
	{
		logger.warn(warningMessage);
	}
	public static void logFatal(String fatalMessage)
	{
		logger.fatal(fatalMessage);
	}
	public static void logTrace(String traceMessage)
	{
		logger.trace(traceMessage);
	}
	public static void logDebug(String debugMessage)
	{
		logger.debug(debugMessage);
	}
}
