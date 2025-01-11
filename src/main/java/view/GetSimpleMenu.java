package view;

import javax.swing.*;

public class GetSimpleMenu extends JMenuItem {

    public GetSimpleMenu() {
        super("Simple");
        addActionListener(e -> UserInterface.updateContent(new GetSimplePanel()));
    }
}
