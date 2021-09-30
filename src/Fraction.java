public class Fraction {
    private int denominateur ;
    private int numerateur ;

    public Fraction(int d, int n) {
        this.denominateur = d;
        this.numerateur = n;
    }

    @Override
    public String toString() {
        return "{" + denominateur +
                "/" + numerateur +
                '}';
    }
}
