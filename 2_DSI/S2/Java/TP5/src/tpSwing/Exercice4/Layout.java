package tpSwing.Exercice4;

import javax.swing.*;
import java.awt.*;

public class Layout extends JFrame {
    public Layout() {
        super("Layout");


        Container pan = this.getContentPane();

        JButton bouton1 = new JButton("Bouton 1");
        JButton bouton2 = new JButton("Bouton 2");
        JButton bouton3 = new JButton("Bouton 3");
        JButton bouton4 = new JButton("Bouton 4");
        JButton bouton5 = new JButton("Bouton 5");

        // pan.add(bouton1);
        // pan.add(bouton2);
        // pan.add(bouton3);
        // pan.add(bouton4);
        // pan.add(bouton5);

        pan.add(bouton1,BorderLayout.NORTH);
        pan.add(bouton2,BorderLayout.WEST);
        pan.add(bouton3);
        pan.add(bouton4,BorderLayout.EAST);
        pan.add(bouton5,BorderLayout.SOUTH);

        setSize(500, 300);
        setVisible(true);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {

        // Layout F1 = new Layout();
        Layout F2 = new Layout();
        // Layout F3 = new Layout();

        // F1.setLayout(new GridLayout(3, 2));
        F2.setLayout(new BorderLayout());
        // F3.setLayout(new FlowLayout());


    }
}

