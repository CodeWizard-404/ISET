package ex2;

public class TestSegment {
    public static void main(String[] args) {
        Point extr1 = new Point(1, 2);
        Point extr2 = new Point(4, 6);
        Segment segment = new Segment(extr1, extr2);

        System.out.println("Segment: " + segment);
        System.out.println("Longueur du segment: " + segment.Longueur());

        Point testPoint = new Point(2, 4);
        if (segment.Appartient(testPoint)) {
            System.out.println(testPoint + " appartient au segment.");
        } else {
            System.out.println(testPoint + " n'appartient pas au segment.");
        }

        segment.translaterSeg(3, 3);
        System.out.println("Segment après translation: " + segment);
    }
}
