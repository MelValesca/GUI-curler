package view;

import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {

    public TextPanel(String text){
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 100));
        JLabel contentLabel = new JLabel(text);
        contentLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createDashedBorder(new Color(226, 226, 226), 1, 1, 1, true),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        contentLabel.setForeground(new Color(226, 226, 226));
        add(contentLabel);
    }

}
