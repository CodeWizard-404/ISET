public class Test {
    public static void main(String[] args) {
        Bibliotheque library = new Bibliotheque(5, 5);

        Livre book1 = new Livre("Book 1", "01-01-2023",  "Author 1");
        Video video1 = new Video("Video 1", "01-02-2023", "Publisher 1", 120.5);
        Livre book2 = new Livre("Book 2", "02-01-2023", "Author 2");
        Video video2 = new Video("Video 2", "02-02-2023", "Publisher 2", 90.5);

        library.ajoutOuvrage(book1);
        library.ajoutOuvrage(video1);
        library.ajoutOuvrage(book2);
        library.ajoutOuvrage(video2);

        Abonne subscriber1 = new Abonne(1, "Subscriber 1", 101, null);
        Abonne subscriber2 = new Abonne(2, "Subscriber 2", 102, null);

        library.ajoutAbonne(subscriber1);
        library.ajoutAbonne(subscriber2);

        library.emprunter("Book 1", 1);
        library.emprunter("Video 1", 2);

        library.rendre(1);

        library.info();

        System.out.println("\nList of videos in the library:");
        for (Video video : library.listeVideos()) {
            System.out.println(video);
        }

        System.out.println("\nLibrary containing only books:");
        Bibliotheque booksLibrary = library.bibLivre();
        booksLibrary.info();
    }
}
