public class Etudiant {
    private int num;
    private String nom;
    private double moy1;
    private double moy2;
    private double moy3;

    public void initEtud(int n, String ch){
        num=n;
        nom=ch;
    }

    public void initMoy(double x, double y, double z){
        moy1=x;
        moy2=y;
        moy3=z;
    }

    public double MoyAnnuel(){
        return (moy1+moy2+moy3)/3;
    }

    public void Affiche(){
        System.out.println("Num : "+num+ "--Nom : "+nom);
        System.out.println("Trimestre 1 ="+moy1);
        System.out.println("Trimestre 2 ="+moy2);
        System.out.println("Trimestre 3 ="+moy3);
        System.out.println("Moyenne Annuelle ="+MoyAnnuel());    
    }

    
    /*public String toString(){
        String ch;
        ch= "Num : "+num+ "--Nom : "+nom+"\n";
        ch+= "Trimestre 1 ="+moy1+"\n";
        ch+= "Trimestre 2 ="+moy2+"\n";
        ch+= "Trimestre 3 ="+moy3+"\n";
        ch+= "Moyenne Annuelle ="+MoyAnnuel();
        
        return ch;
    }*/
}
