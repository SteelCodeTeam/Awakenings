package net.steelcodeteam.awakenings.modules.error_handling.messages;



import net.steelcodeteam.awakenings.Awakenings;
import net.steelcodeteam.awakenings.modules.error_handling.exceptions.SeverityType;

import javax.annotation.Nullable;

/**
 * LoggerUtils is a utility class that provides methods for logging messages with different severity levels.
 * It uses the Awakenings.LOGGER for logging and builds appropriate log messages based on the provided
 * error code, message, optional stack trace, and severity type.
 *
 * @author SteelCode Team
 * @since 1.5.1
 */
public class LoggerUtils {

    /**
     * Logs a message with the specified severity level, error code, message, and optional stack trace.
     *
     * @param code       the error code
     * @param message    the error message
     * @param stackTrace the optional stack trace, can be null
     * @param severity   the severity level of the log message
     */
    public static void printLog(String code, String message, @Nullable StackTraceElement[] stackTrace, SeverityType severity) {
        if (severity == SeverityType.INFO) {
            printLogInfo(code, message, stackTrace);
        } else if (severity == SeverityType.DEBUG) {
            printLogDebug(code, message, stackTrace);
        } else if (severity == SeverityType.WARN) {
            printLogWarn(code, message, stackTrace);
        } else if (severity == SeverityType.ERROR) {
            printLogError(code, message, stackTrace);
        } else {
            printLogWarn(code, message, stackTrace);
        }
    }

    /**
     * Logs an INFO level message with the specified error code, message, and optional stack trace.
     *
     * @param code       the error code
     * @param message    the error message
     * @param stackTrace the optional stack trace, can be null
     */
    public static void printLogInfo(String code, String message, @Nullable StackTraceElement[] stackTrace) {
        String messageBuilt = buildMessage(code, message, stackTrace);
        Awakenings.LOGGER.info(messageBuilt);
    }

    /**
     * Logs a INFO level message with the specified error message.
     *
     * @param message the error message
     */
    public static void printLogInfo(String message) {
        Awakenings.LOGGER.info(message);
    }

    /**
     * Logs an DEBUG level message with the specified error code, message, and optional stack trace.
     *
     * @param code       the error code
     * @param message    the error message
     * @param stackTrace the optional stack trace, can be null
     */
    public static void printLogDebug(String code, String message, @Nullable StackTraceElement[] stackTrace) {
        String messageBuilt = buildMessage(code, message, stackTrace);
        Awakenings.LOGGER.debug(messageBuilt);
    }

    /**
     * Logs a DEBUG level message with the specified error message.
     *
     * @param message the error message
     */
    public static void printLogDebug(String message) {
        Awakenings.LOGGER.debug(message);
    }

    /**
     * Logs an WARN level message with the specified error code, message, and optional stack trace.
     *
     * @param code       the error code
     * @param message    the error message
     * @param stackTrace the optional stack trace, can be null
     */
    public static void printLogWarn(String code, String message, @Nullable StackTraceElement[] stackTrace) {
        String messageBuilt = buildMessage(code, message, stackTrace);
        Awakenings.LOGGER.warn(messageBuilt);
    }

    /**
     * Logs a WARN level message with the specified error message.
     *
     * @param message the error message
     */
    public static void printLogWarn(String message) {
        Awakenings.LOGGER.warn(message);
    }

    /**
     * Logs an ERROR level message with the specified error code, message, and optional stack trace.
     *
     * @param code       the error code
     * @param message    the error message
     * @param stackTrace the optional stack trace, can be null
     */
    public static void printLogError(String code, String message, @Nullable StackTraceElement[] stackTrace) {
        String messageBuilt = buildMessage(code, message, stackTrace);
        Awakenings.LOGGER.error(messageBuilt);
    }

    /**
     * Logs an ERROR level message with the specified error message.
     *
     * @param message the error message
     */
    public static void printLogError(String message) {
        Awakenings.LOGGER.error(message);
    }

    /**
     * Builds a log message with the specified error code, message, and optional stack trace.
     *
     * @param code       the error code
     * @param message    the error message
     * @param stackTrace the optional stack trace, can be null
     * @return the formatted log message
     */
    private static String buildMessage(String code, String message, @Nullable StackTraceElement[] stackTrace) {
        StringBuilder messageBuilder = new StringBuilder(code + ": " + message);

        if (stackTrace != null && stackTrace.length != 0) {
            messageBuilder.append(" Stacktrace: \n");
            for (StackTraceElement trace: stackTrace) {
                messageBuilder.append(trace.toString()).append("\n");
            }
        }
        return messageBuilder.toString();
    }
}
