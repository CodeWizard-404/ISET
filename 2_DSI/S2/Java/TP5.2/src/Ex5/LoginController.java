package Ex5;

public class LoginController {
    private LoginView loginView;
    private LoginModel loginModel;

    public LoginController() {
        loginView = new LoginView(this);
        loginModel = new LoginModel("login-password.txt");
    }

    public void start() {
        loginView.afficher(true);
    }

    public void boutonValider() {
        String login = loginView.getLogin();
        String password = loginView.getPassword();

        if (loginModel.estValide(login, password)) {
            loginView.afficherMessage("Login correct");
        } else {
            loginView.afficherMessage("Login incorrect");
        }
    }
}