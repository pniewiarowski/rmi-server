package org.pniewiarowski.rmi.time;

import org.pniewiarowski.rmi.time.definition.LocalTimeInterface;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalTime implements LocalTimeInterface {
    @Override
    public String get() {
        var now = LocalDateTime.now();
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return now.format(formatter);
    }
}
