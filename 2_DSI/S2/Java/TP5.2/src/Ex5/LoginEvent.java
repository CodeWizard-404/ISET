package Ex5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginEvent implements ActionListener {
    private LoginController loginController;

    public LoginEvent(LoginController loginController) {
        this.loginController = loginController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        loginController.boutonValider();
    }
}