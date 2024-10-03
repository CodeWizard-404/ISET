public abstract class CompteurAbstrait {
    protected int min;
    protected int courant;

    public CompteurAbstrait(int min) throws MinException {
        if (min < 0) {
            throw new MinException("min cannot be negative");
        }
        this.min = min;
        this.courant = min;
    }

    public void raz() {
        this.courant = min;
    }

    public abstract void Increment();

}
