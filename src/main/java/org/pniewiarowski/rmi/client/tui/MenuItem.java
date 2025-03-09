package org.pniewiarowski.rmi.client.tui;

import org.pniewiarowski.rmi.client.tui.definition.TUIItemInterface;

public class MenuItem implements TUIItemInterface {
    public String key;
    public String label;

    public MenuItem(String key, String label) {
        this.key = key;
        this.label = label;
    }

    @Override
    public String display() {
        return String.format("[%s] %s", key, label);
    }
}
