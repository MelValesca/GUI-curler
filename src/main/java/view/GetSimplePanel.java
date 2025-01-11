package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class GetSimplePanel extends JPanel {

    private final String TEXT = "<html><center>Get Simple!<br>" +
            "Make a simple curl request.<br>" +
            "Which page do you want to see ?</center></html>";
    private static final ResultPanel content = new ResultPanel();

    public GetSimplePanel(){
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        setMaximumSize(new Dimension(1200, Integer.MAX_VALUE));

        add(new TextPanel(TEXT),BorderLayout.NORTH);
        add(createInputPanel(),BorderLayout.WEST);
        add(content,BorderLayout.EAST);
    }

//    private JPanel createMainText(){
//        JPanel panel = new JPanel(new BorderLayout());
//
//        panel.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 100));
//        JLabel contentLabel = new JLabel(
//                "<html><center>Get Simple!<br>" +
//                        "Make a simple curl request.<br>" +
//                        "Which page do you want to see ?</center></html>"
//        );
//        contentLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        contentLabel.setBorder(BorderFactory.createCompoundBorder(
//                BorderFactory.createDashedBorder(new Color(226, 226, 226), 1, 1, 1, true),
//                BorderFactory.createEmptyBorder(10, 10, 10, 10)
//        ));
//        contentLabel.setForeground(new Color(226, 226, 226));
//        panel.add(contentLabel);
//        return panel;
//    }

    private JPanel createInputPanel() {
        JLabel label = new JLabel("URL:");
        label.setForeground(new Color(226, 226, 226));
        JTextField textField = new PasteTF(20);
        JButton curlButton = new JButton("Curl");

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inputPanel.add(label);
        inputPanel.add(textField);
        inputPanel.add(curlButton);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 100, 0, 0));

        JCheckBox showHeadersCheckbox = new JCheckBox("Show headers");
        showHeadersCheckbox.setForeground(new Color(226, 226, 226));
        JPanel checkboxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        checkboxPanel.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 0));
        checkboxPanel.add(showHeadersCheckbox);

        JPanel headers = new JPanel(new BorderLayout());
        JLabel headersLabel = new JLabel(" Add headers to your request:");
        headersLabel.setForeground(new Color(226, 226, 226));
        JTextArea headersTextArea = new PasteTA(7, 25);
        headersTextArea.setLineWrap(true);
        headersTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(headersTextArea);
        headers.setBorder(BorderFactory.createEmptyBorder(10, 100, 415, 0));
        headers.add(headersLabel, BorderLayout.NORTH);
        headers.add(scrollPane, BorderLayout.CENTER);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(inputPanel,BorderLayout.NORTH);
        mainPanel.add(checkboxPanel,BorderLayout.CENTER);
        mainPanel.add(headers, BorderLayout.SOUTH);

        curlButton.addActionListener(e -> {
            String url = textField.getText();
            content.changeText(Controller.getSimple(url, showHeadersCheckbox.isSelected(),headersTextArea.getText()));
        });

        return mainPanel;
    }

}
