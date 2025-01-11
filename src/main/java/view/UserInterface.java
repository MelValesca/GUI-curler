package view;

import javax.swing.*;
import java.awt.*;

public class UserInterface extends JFrame {

    private static JPanel content;

    public UserInterface() {
        super("Curler");

        setDarkMode();

        JMenuBar menuBar = createMenuBar();
        JPanel headerPanel = createHeaderPanel();
        content = createContentPanel();

        setJMenuBar(menuBar);

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        getContentPane().add(headerPanel);
        getContentPane().add(content);
        getContentPane().setBackground(new Color(128, 128, 128));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 900);
        setVisible(true);
    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.DARK_GRAY);
        headerPanel.setLayout(new BorderLayout());

        JLabel headerLabel = new JLabel("No curls, no gurls !");
        headerLabel.setForeground(new Color(226, 226, 226));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        headerPanel.add(headerLabel, BorderLayout.CENTER);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        headerPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));

        return headerPanel;
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu getMethodMenu = new JMenu("GET");
        JMenuItem getMenuItem1 = new GetSimpleMenu();
        JMenuItem getMenuItem2 = new FFUFMenu();
        JMenuItem getMenuItem3 = new JMenuItem("Action3");

        getMethodMenu.add(getMenuItem1);
        getMethodMenu.add(getMenuItem2);
        getMethodMenu.add(getMenuItem3);

        JMenu postMethodMenu = new JMenu("POST");
        JMenuItem postMenuItem1 = new JMenuItem("Action4");
        JMenuItem postMenuItem2 = new JMenuItem("Action5");
        JMenuItem postMenuItem3 = new JMenuItem("Action6");

        postMethodMenu.add(postMenuItem1);
        postMethodMenu.add(postMenuItem2);
        postMethodMenu.add(postMenuItem3);

        menuBar.add(getMethodMenu);
        menuBar.add(postMethodMenu);

        return menuBar;
    }

    private void setDarkMode() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.put("nimbusBase", new Color(18, 30, 49));
            UIManager.put("nimbusBlueGrey", new Color(128, 128, 128));
            UIManager.put("control", new Color(128, 128, 128));
            UIManager.put("MenuBar.background", new Color(18, 30, 49));
            UIManager.put("MenuBar.foreground", new Color(226, 226, 226));
            UIManager.put("Menu.background", new Color(18, 30, 49));
            UIManager.put("Menu.foreground", new Color(226, 226, 226));
            UIManager.put("MenuItem.background", new Color(18, 30, 49));
            UIManager.put("MenuItem.foreground", new Color(226, 226, 226));
            UIManager.put("PopupMenu.background", new Color(18, 30, 49));
            UIManager.put("PopupMenu.border", BorderFactory.createLineBorder(new Color(18, 30, 49)));
            UIManager.put("Label.foreground", new Color(226, 226, 226));
            UIManager.put("TextField.foreground", new Color(18, 30, 49));
            UIManager.put("TextArea.foreground", new Color(18, 30, 49));
            UIManager.put("TextField.selectionBackground", new Color(60, 76, 101));
            UIManager.put("TextField.selectionForeground", Color.WHITE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateContent(JPanel panel) {
        Container parent = content.getParent();
        parent.remove(content);
        content = panel;
        parent.add(content);
        parent.revalidate();
        parent.repaint();
    }

    private JPanel createContentPanel() {
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        contentPanel.setMaximumSize(new Dimension(700, Integer.MAX_VALUE));

        JLabel contentLabel = new JLabel(
                "<html><center>Welcome!<br>" +
                        "This is version 1.0 of the Curler tool.<br>" +
                        "Curler tool is a simplified desktop application to run your favourite exploits.<br>" +
                        "It's not an official tool nor is it really that useful.<br>" +
                        "This tool was created to simplify your CTF experiences.</center></html>"
        );
        contentLabel.setForeground(new Color(226, 226, 226));

        contentPanel.add(contentLabel, BorderLayout.NORTH);
        contentLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createDashedBorder(new Color(226, 226, 226), 1, 1, 1, true),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        contentPanel.add(contentLabel, BorderLayout.NORTH);

        return contentPanel;
    }
}




