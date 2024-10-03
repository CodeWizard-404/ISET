package tpSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculatrice extends JFrame implements ActionListener {
    private JTextField textField;

    public Calculatrice() {
        super("Calculatrice");

        textField = new JTextField(10);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this); 
            buttonPanel.add(button);
        }

        getContentPane().add(textField, BorderLayout.NORTH);
        getContentPane().add(buttonPanel, BorderLayout.CENTER);

        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }



    private double op1 = 0;
    private String opr = "";

    private void calculateResult() {
        double result = 0;
        double op2 = Double.parseDouble(textField.getText());
        switch (opr) {
            case "+":
                result = op1 + op2;
                break;
            case "-":
                result = op1 - op2;
                break;
            case "*":
                result = op1 * op2;
                break;
            case "/":
                result = op1 / op2;
                break;
        }
        textField.setText(Double.toString(result));
    }




    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();  
        if (command.matches("[0-9]+") || command.equals(".")) {
            textField.setText(textField.getText() + command);
        } else if (command.equals("=")) {
            calculateResult();
        } else {
            opr = command;
            op1 = Double.parseDouble(textField.getText());
            textField.setText("");
        }
    }




    public static void main(String[] args) {
        new Calculatrice();
    }
}









