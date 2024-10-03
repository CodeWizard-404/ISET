package Ex2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextFormatter extends JFrame {
    private JTextArea inputTextArea, formattedTextArea;
    private JRadioButton redButton, blueButton;
    private JCheckBox upperCaseCheckBox;

    public TextFormatter() {
        super("Text Formatter App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        // Label for input text area
        JLabel inputLabel = new JLabel("Saisir Votre text:");
        add(inputLabel);

        // Text area for input text
        inputTextArea = new JTextArea();
        add(new JScrollPane(inputTextArea));



        // Panel for color options
        JPanel colorPanel = new JPanel(new GridLayout(2, 1));

        // Radio buttons for color
        redButton = new JRadioButton("Rouge");
        blueButton = new JRadioButton("Bleu");
        ButtonGroup colorGroup = new ButtonGroup();
        colorGroup.add(redButton);
        colorGroup.add(blueButton);
        redButton.addActionListener(new ColorChangeListener(Color.RED));
        blueButton.addActionListener(new ColorChangeListener(Color.BLUE));
        colorPanel.add(redButton);
        colorPanel.add(blueButton);
        add(colorPanel);

        // Check box for case
        upperCaseCheckBox = new JCheckBox("Majuscule");
        upperCaseCheckBox.addActionListener(new CaseChangeListener());
        add(upperCaseCheckBox); 
        

        // Label for formatted text area
        JLabel formattedLabel = new JLabel("Text mis en forme:");
        add(formattedLabel);

        // Text area for formatted text
        formattedTextArea = new JTextArea();
        formattedTextArea.setEditable(false); 
        
        add(new JScrollPane(formattedTextArea));



        setVisible(true);
    }

    class ColorChangeListener implements ActionListener {
        private Color color;

        public ColorChangeListener(Color color) {
            this.color = color;
        }

        public void actionPerformed(ActionEvent e) {
            updateFormattedText();
        }
    }

    class CaseChangeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            updateFormattedText();
        }
    }

    private void updateFormattedText() {
        String text = inputTextArea.getText();
        if (upperCaseCheckBox.isSelected()) {
            text = text.toUpperCase();
        } else {
            text = text.toLowerCase();
        }
        if (redButton.isSelected()) {
            formattedTextArea.setForeground(Color.RED);
        } else if (blueButton.isSelected()) {
            formattedTextArea.setForeground(Color.BLUE);
        }
        formattedTextArea.setText(text);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TextFormatter();
            }
        });
    }
}
