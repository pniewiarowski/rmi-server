package org.pniewiarowski.rmi.client.tui;

import org.pniewiarowski.rmi.client.tui.definition.TUIItemInterface;

import java.util.List;

public class Menu implements TUIItemInterface {
    private final Heading heading;
    public final List<MenuItem> menuItems;

    public Menu(Heading heading, List<MenuItem> menuItems) {
        this.heading = heading;
        this.menuItems = menuItems;
    }

    @Override
    public String display() {
        StringBuilder result = new StringBuilder();

        result.append(String.format("%s%n%n", heading.display()));
        for (MenuItem menuItem : menuItems) {
            result.append(String.format("%s%n", menuItem.display()));
        }

        return result.toString();
    }
}
