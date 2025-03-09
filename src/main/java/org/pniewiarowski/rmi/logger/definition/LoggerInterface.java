package org.pniewiarowski.rmi.logger.definition;

/**
 * Provides an interface for logging informational messages.
 * This interface defines a method to log messages with an "info" level.
 */
public interface LoggerInterface {
    /**
     * Logs an informational message.
     *
     * @param message The message to be logged.
     */
    public void info(String message);
}
