public class TestRobot {
    public static void main(String[] args) {
        Robot robot1 = new Robot(1, 0, 0);
        Robot robot2 = new Robot(1, 3, 4);

        robot1.Affiche();
        robot2.Affiche();

        robot1.Avancer();
        robot2.Tourner(1);

        robot1.Affiche();
        robot2.Affiche();

        System.out.println("Nombre total de robots: " + Robot.getCount());
        System.out.println(3 % 4);
    }
}
