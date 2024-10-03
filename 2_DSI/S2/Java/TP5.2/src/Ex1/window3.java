package Ex1;

import javax.swing.*;
import java.awt.event.*;

// objet écouteur

class MonEcouteur extends MouseAdapter {
    public void mousePressed(MouseEvent e) {
        System.out.println("Appui : X=" + e.getX() + ", Y=" + e.getY());
    }

    public void mouseReleased(MouseEvent e) {
        System.out.println("Relâchement : X=" + e.getX() + ", Y=" + e.getY());
    }
}

public class window3 extends JFrame {
    public window3() {
        super("Fenêtre avec écouteur de souris");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        MonEcouteur ecouteur = new MonEcouteur();
        addMouseListener(ecouteur);
    }

    public static void main(String[] args) {
        new window3();
    }
}
