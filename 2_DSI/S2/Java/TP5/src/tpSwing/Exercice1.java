package tpSwing;

import javax.swing.JFrame;

public class Exercice1 extends JFrame {
    public Exercice1() {
        initUI();
    }

    private void initUI() {
        setTitle("Exemple simple");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Exercice1 ex = new Exercice1();
        ex.setVisible(true);
    }
}