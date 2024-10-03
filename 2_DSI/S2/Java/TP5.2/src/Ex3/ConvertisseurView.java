package Ex3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConvertisseurView extends JFrame {
    private JLabel piedsLabel, metresLabel;
    private JTextField piedsTextField, metresTextField;
    private JButton piedsButton, metresButton;

    public ConvertisseurView() {
        super("Convertisseur pieds-mètres");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Container container = getContentPane();
        container.setLayout(new GridLayout(2, 3));

        piedsLabel = new JLabel("Hauteur en pieds ");
        container.add(piedsLabel);

        piedsTextField = new JTextField("0");
        container.add(piedsTextField);

        piedsButton = new JButton("Calculer pieds-mètres");
        container.add(piedsButton);

        metresLabel = new JLabel("Hauteur en mètre ");
        container.add(metresLabel);

        metresTextField = new JTextField("0");
        container.add(metresTextField);

        metresButton = new JButton("Calculer mètres-pieds");
        container.add(metresButton);

        piedsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    double feet = Double.parseDouble(piedsTextField.getText());
                    double meters = feet * 0.3048; 
                    metresTextField.setText(String.valueOf(meters));

            }
        });

        metresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    double meters = Double.parseDouble(metresTextField.getText());
                    double feet = meters / 0.3048; 
                    piedsTextField.setText(String.valueOf(feet));
            }
        });

        setVisible(true);
        pack();
    }

}
