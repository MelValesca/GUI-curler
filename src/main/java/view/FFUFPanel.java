package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class FFUFPanel extends JPanel {

    private final String TEXT = "<html><center>Get FFUFing!<br>" +
                                "Fuzz Faster U Fool.<br>" +
                                "Want to see if a website has any hidden pages ?</center></html>";

    private final JTextArea textArea = new JTextArea(20,35);


    public FFUFPanel(){
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        setMaximumSize(new Dimension(1200, Integer.MAX_VALUE));
        textArea.setText("""
                The existing paths will show dynamically here.
                Wait.
                
                """);

        add(new TextPanel(TEXT),BorderLayout.NORTH);
        add(createInputPanel(),BorderLayout.WEST);
        add(createTAPanel(),BorderLayout.EAST);
    }

    private JPanel createTAPanel(){
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 200, 200));
        panel.add(textArea);
        return panel;
    }


    private JPanel createInputPanel() {
        JLabel label = new JLabel("URL:");
        label.setForeground(new Color(226, 226, 226));
        JTextField textField = new PasteTF(20);
        JButton curlButton = new JButton("FFUF");

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inputPanel.add(label);
        inputPanel.add(textField);
        inputPanel.add(curlButton);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 200, 0, 0));

        JPanel headers = new JPanel(new BorderLayout());
        JLabel headersLabel = new JLabel(" Add headers for your FFUF:");
        headersLabel.setForeground(new Color(226, 226, 226));
        JTextArea headersTextArea = new PasteTA(7, 5);
        headersTextArea.setLineWrap(true);
        headersTextArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(headersTextArea);
        headers.setBorder(BorderFactory.createEmptyBorder(10, 200, 415, 0));
        headers.add(headersLabel, BorderLayout.NORTH);
        headers.add(scrollPane, BorderLayout.CENTER);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(inputPanel,BorderLayout.NORTH);
        mainPanel.add(headers, BorderLayout.CENTER);

        curlButton.addActionListener(e -> {
            String url = textField.getText();
            try {
                Controller.checkURLs(url,"",textArea);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        return mainPanel;
    }
}
