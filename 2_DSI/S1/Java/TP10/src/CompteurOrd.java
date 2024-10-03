public class CompteurOrd extends CompteurAbstrait {
    public CompteurOrd(int min) throws MinException {
        super(min);
    }

    public void Increment() {
        this.courant++;
    }
}
