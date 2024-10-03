package Ex5;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton validateButton;
    private JLabel loginLabel, passwordLabel;

    public LoginView(LoginController controller) {
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create GUI components
        loginLabel = new JLabel("Login:");
        loginField = new JTextField(15);
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(15);
        validateButton = new JButton("Validate");
        validateButton.addActionListener(new LoginEvent(controller));

        // Layout components
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        panel.add(loginLabel);
        panel.add(loginField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(validateButton);

        add(panel, BorderLayout.CENTER);
    }

    public String getLogin() {
        return loginField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public void afficher(boolean reponse) {
        setVisible(reponse);
    }

    protected void afficherMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }
}