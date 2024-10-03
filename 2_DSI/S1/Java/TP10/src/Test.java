public class Test {
    public static void main(String[] args) {
        try {
            CompteurAbstrait compteurOrd = new CompteurOrd(5);
            CompteurAbstrait compteurCycl = new CompteurCycl(10, 15);

            for (int i = 0; i < 10; i++) {
                compteurOrd.Increment();
                compteurCycl.Increment();

                System.out.println("CompteurOrd: " + compteurOrd.courant + "  -- CompteurCycl: " + compteurCycl.courant);
                System.out.println();
            }

            System.out.println("Resetting Counters...");
            compteurOrd.raz();
            compteurCycl.raz();

            System.out.println("CompteurOrd after reset: " + compteurOrd.courant);
            System.out.println("CompteurCycl after reset: " + compteurCycl.courant);
        } catch (MinException | MaxException e) {
            e.printStackTrace();
        }
    }
}
