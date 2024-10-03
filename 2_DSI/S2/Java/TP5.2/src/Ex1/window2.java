package Ex1;

import javax.swing.*;
import java.awt.event.*;

//  écouteur différent

class MonEcouteur implements MouseListener {
    public void mousePressed(MouseEvent e) {
        System.out.println("Appui : X=" + e.getX() + ", Y=" + e.getY());
    }

    public void mouseReleased(MouseEvent e) {
        System.out.println("Relâchement : X=" + e.getX() + ", Y=" + e.getY());
    }

    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}

public class window2 extends JFrame {
    public window2() {
        super("Fenêtre avec écouteur de souris");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        MonEcouteur ecouteur = new MonEcouteur();
        addMouseListener(ecouteur);
    }

    public static void main(String[] args) {
        new window2();
    }
}
