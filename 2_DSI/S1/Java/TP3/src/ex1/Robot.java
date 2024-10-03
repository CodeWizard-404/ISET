public class Robot {
    private int orientation;
    private int abs;
    private int ord;

    private static int count = 0;
    private int num;

    public Robot(int orientation, int abs, int ord) {
        this.orientation = orientation;
        this.abs = abs;
        this.ord = ord;
        count++;
        num = count;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOientation(int orientation) {
        this.orientation = orientation;
    }

    public int getAbs() {
        return abs;
    }

    public void setAbs(int abs) {
        this.abs = abs;
    }

    public int getOrd() {
        return ord;
    }

    public void setOrd(int ord) {
        this.ord = ord;
    }

    public static int getCount() {
        return count;
    }

    public int getNum() {
        return num;
    }

    public void Avancer() {
        switch (orientation) {
            case 1:
                ord++;
                break;
            case 2:
                abs++;
                break;
            case 3:
                ord--;
                break;
            case 4:
                abs--;
                break;
        }
    }

    public void Avancer(int a) {
        switch (orientation) {
            case 1:
                ord += a;
                break;
            case 2:
                abs += a;
                break;
            case 3:
                ord -= a;
                break;
            case 4:
                abs -= a;
                break;
        }
    }

    public void Tourner(int x) {
        if (x >= 0) {
            orientation = (orientation % 4) + 1;
        } else {
            orientation = ((orientation + 2) % 4) + 1;
        }
    }

    public String toString() {
        return "Robot " + num + ": Orientation = " + orientation + ", Position = (" + abs + ", " + ord + ")";
    }

    public void Affiche() {
        System.out.println(toString());
    }
}