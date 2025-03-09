package org.pniewiarowski.rmi.time.definition;

/**
 * Provides an interface for retrieving the current local time.
 * This interface defines a method to fetch the time as a string representation.
 */
public interface LocalTimeInterface {
    /**
     * Retrieves the current local time as a string.
     *
     * @return A string representing the current local time.
     */
    public String get();
}
