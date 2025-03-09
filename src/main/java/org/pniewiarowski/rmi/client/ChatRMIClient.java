package org.pniewiarowski.rmi.client;

import org.pniewiarowski.rmi.client.tui.Heading;
import org.pniewiarowski.rmi.client.tui.Menu;
import org.pniewiarowski.rmi.client.tui.MenuItem;
import org.pniewiarowski.rmi.server.definition.ChatRMIServerInterface;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.util.ArrayList;

public class ChatRMIClient {
    private final static String BINDING_NAME = "//localhost/ChatRMIServer";

    public static void main(String[] args) {
        try {
            System.setProperty("java.security.policy", "security.policy");

            var calculatorRMIRemote = (ChatRMIServerInterface) Naming.lookup(BINDING_NAME);
            var mainMenuHeading = new Heading("chat client");
            var mainMenuItems = new ArrayList<MenuItem>();
            mainMenuItems.add(new MenuItem("a", "add"));
            mainMenuItems.add(new MenuItem("r", "read"));
            mainMenuItems.add(new MenuItem("e", "exit"));

            var mainMenu = new Menu(mainMenuHeading, mainMenuItems);
            var reader = new BufferedReader(new InputStreamReader(System.in));
            var run = true;
            while (run) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.print(mainMenu.display());

                var option = reader.readLine();
                switch (option) {
                    case "a", "add":
                        break;
                    case "e", "exit":
                        run = false;
                        break;
                    default:
                        System.out.println("Invalid option...");
                }
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
