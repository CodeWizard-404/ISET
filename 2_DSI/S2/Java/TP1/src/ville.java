import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ville {

    private int nbrHabitants, nbrJeunes;

    public int getNombreHabitants() {
        return nbrHabitants;
    }

    public void setNbrHabitants(int nbrHabitants) {
        this.nbrHabitants = nbrHabitants;
    }

    public int getNombreJeunes() {
        return nbrJeunes;
    }

    public void setNbrJeunes(int nbrJeunes) {
        this.nbrJeunes = nbrJeunes;
    }

    public ville(int nbrHabitants, int nbrJeunes) {
        this.nbrHabitants = 0;
        this.nbrJeunes = 0;
    }

    public int pourcentageJeunes() {
        int res = 0;
        try {
            res = (getNombreJeunes() * 100 / getNombreHabitants());
            return res;
        } catch (ArithmeticException e) {
            System.out.println("Nombre Habitants doit être non nul : " + e.getMessage());
        }

        finally {
            System.out.println("Exécuté dans tous les cas ");
        }
        return res;
    }

    public void lireFichier() throws FileNotFoundException, IOException {

        BufferedReader br = new BufferedReader(new FileReader("fichier.txt"));
        String line = br.readLine();
        System.out.println(line);
        br.close();

    }

    public ville(int nombreHabitants) throws NombreHabitantsException {
        if (nombreHabitants < 0)
            throw new NombreHabitantsException();
        else
            this.nbrHabitants = nombreHabitants;
    }

}