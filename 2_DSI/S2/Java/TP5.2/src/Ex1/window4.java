package Ex1;

import javax.swing.*;
import java.awt.event.*;

// classe anonyme dérivée de MouseAdapter

public class window4 extends JFrame {
    public window4() {
        super("Fenêtre avec écouteur de souris");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                System.out.println("Appui : X=" + e.getX() + ", Y=" + e.getY());
            }

            public void mouseReleased(MouseEvent e) {
                System.out.println("Relâchement : X=" + e.getX() + ", Y=" + e.getY());
            }
        });
    }

    public static void main(String[] args) {
        new window4();
    }
}
