package Ex4;

import javax.swing.*;
import java.awt.*;

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


        setVisible(true);
        pack();

        piedsButton.addActionListener(new ConvertisseurEvent(this)); 
        piedsButton.setActionCommand("piedsmetres"); 
        metresButton.addActionListener(new ConvertisseurEvent(this)); 
        metresButton.setActionCommand("metrespieds");

        
    }

    public void afficherPieds() { 
        float pieds = Float.parseFloat(metresTextField.getText()) / 0.305f; 
        piedsTextField.setText(String.valueOf(pieds)); 
    } 
    
    public void afficherMetres() { 
        float metres = Float.parseFloat(piedsTextField.getText()) * 0.305f; 
        metresTextField.setText(String.valueOf(metres)); 
    }
    
    

}
