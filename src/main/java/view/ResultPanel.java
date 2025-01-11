package view;

import javax.swing.*;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import javax.swing.*;
import java.awt.*;

public class ResultPanel extends JPanel {

    private static final RSyntaxTextArea textArea = new RSyntaxTextArea();

    public ResultPanel(){
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 100));
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_HTML);
        textArea.setCodeFoldingEnabled(true);
        textArea.setText("Your response will show here");
        JScrollPane scrollPane = new JScrollPane(textArea);
        setPreferredSize(new Dimension(710, 500));

        JButton generateCodeButton = new JButton("Generate HTML");
        generateCodeButton.addActionListener(e -> {
            showHTMLAppearance(textArea.getText());
        });
        add(scrollPane, BorderLayout.CENTER);
        add(generateCodeButton, BorderLayout.SOUTH);
    }

    public void changeText(String html){
        textArea.setText(html);
    }

    private void showHTMLAppearance(String html) {
        JTextPane textPane = new JTextPane();
        textPane.setContentType("text/html");
        textPane.setText(html);
        textPane.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setPreferredSize(new Dimension(600, 500));

        JOptionPane.showMessageDialog(null, scrollPane, "HTML Appearance", JOptionPane.PLAIN_MESSAGE);
    }
}


