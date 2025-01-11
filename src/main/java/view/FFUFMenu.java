package view;

import javax.swing.*;

public class FFUFMenu extends JMenuItem {

    public FFUFMenu() {
        super("FFUF");
        addActionListener(e -> UserInterface.updateContent(new FFUFPanel()));
    }
}
