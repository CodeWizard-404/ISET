package tpSwing.Exercice2;
import javax.swing.*;

public class MaPremiereFenetre extends JFrame{
    public MaPremiereFenetre(String Titre) {
        super(Titre);

        JLabel premierLabel = new JLabel("Hello World");
        this.add(premierLabel);
        this.setSize(300, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

    }
}
