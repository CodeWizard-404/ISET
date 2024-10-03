public class CompteurCycl extends CompteurAbstrait {
    private int max;

    public CompteurCycl(int min, int max) throws MinException, MaxException {
        super(min);
        if (max <= min) {
            throw new MaxException("max must be greater than min");
        }
        this.max = max;
    }

    public void Increment() {
        if (this.courant > this.max) {
            this.courant = this.min;
        }
        this.courant++;
    }
}

