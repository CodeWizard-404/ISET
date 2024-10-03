public class Program {
    public static void main(String[] args) throws Exception {
        ville ville1 = new ville(300, 100);
        ville ville2 = new ville(0, 100);
        System.out.println("Pourcentage de jeunes dans la deuxième ville: "+ville1.pourcentageJeunes()); 
        System.out.println("Pourcentage de jeunes dans la deuxième ville: " + ville2.pourcentageJeunes());

        try{
            ville1.lireFichier();
        }
        catch (Exception e) {}

        try {
            ville v=new ville(-500);
        }
        catch (NombreHabitantsException e) {}

    }
}