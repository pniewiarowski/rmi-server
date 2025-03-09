package org.pniewiarowski.rmi.client.tui;

import org.pniewiarowski.rmi.client.tui.definition.TUIItemInterface;

public class Heading implements TUIItemInterface {
    private final String text;

    public Heading(String text) {
        this.text = text;
    }

    @Override
    public String display() {
        return text.toUpperCase();
    }
}
