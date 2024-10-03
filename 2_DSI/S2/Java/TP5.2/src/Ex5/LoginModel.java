package Ex5;

import java.io.*;

public class LoginModel {
    private String nomFichier;

    public LoginModel(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public boolean estValide(String login, String pwd) {
        String ligne = null;
        String[] temp = null;
        try {
            BufferedReader entree = new BufferedReader(new FileReader(nomFichier));
            while ((ligne = entree.readLine()) != null) {
                temp = ligne.split(":");
                if (temp[0].equals(login)) {
                    if (temp[1].equals(pwd)) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        return false;
    }
}