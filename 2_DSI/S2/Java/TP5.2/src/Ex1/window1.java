package Ex1;

import javax.swing.*;
import java.awt.event.*;

//  propre écouteur

public class window1 extends JFrame implements MouseListener {
    public window1() {
        super("Fenêtre avec écouteur de souris");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        addMouseListener(this);
    }

    public void mousePressed(MouseEvent e) {
        System.out.println("Appui : X=" + e.getX() + ", Y=" + e.getY());
    }

    public void mouseReleased(MouseEvent e) {
        System.out.println("Relâchement : X=" + e.getX() + ", Y=" + e.getY());
    }

    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new window1();
    }
}
