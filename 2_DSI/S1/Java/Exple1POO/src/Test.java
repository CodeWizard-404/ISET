public class Test {

    public static void main(String[] args){
        Etudiant E;
        E=new Etudiant();
        E.initEtud(15, "Ali");
        E.initMoy(15, 16, 16.5);

        //E.Affiche();
        
        //System.out.println(E.MoyAnnuel());

        System.out.println(E.toString());
    }
    
}
