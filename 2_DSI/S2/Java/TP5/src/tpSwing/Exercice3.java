package tpSwing;

import javax.swing.*;
import java.awt.*;
public class Exercice3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercice 3");
        JButton button = new JButton("clic clic");
        JLabel label = new JLabel("un petit text");
        JButton button2 = new JButton("2eme bouton");
        JButton button3 = new JButton("3eme bouton");
        JButton button4 = new JButton("4eme bouton");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,2));
        panel.add(button);
        panel.add(label);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }
}
