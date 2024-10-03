package EX2;

import java.util.HashMap;
import java.util.Map;

public class GererMap {
    public static void main(String[] args) {
        HashMap<String, Abonne> annuaire = new HashMap<>();

        annuaire.put("71789654", new Abonne("71789654", "AHMED", "Tunis"));
        annuaire.put("71916544", new Abonne("71916544", "MOHAMED", "Ariana"));
        annuaire.put("71952654", new Abonne("71952654", "SALEH", "Ben Arous"));
        annuaire.put("71789952", new Abonne("71789952", "ALI", "Manouba"));

        System.out.println("Nombre d entrees: " + annuaire.size() + ":\n" + annuaire + "\n");

        System.out.println("Abonne du cle 71789654: " + annuaire.get("71789654"));
        System.out.println("Abonne du cle 72159987: " + annuaire.get("72159987"));
        
        annuaire.put("73123456", new Abonne("73123456", "FAKHER", "Nabeul"));
        System.out.println("\nApres ajout de FAKHER : " + annuaire + "\n");

        System.out.println("Parcours map entrySet():");
        for (Map.Entry<String, Abonne> entry : annuaire.entrySet()) {
            System.out.println(entry.getValue());
        }

        System.out.println("\nParcours map keySet():");
        for (String key : annuaire.keySet()) {
            System.out.println(annuaire.get(key));
        }
    }
}

