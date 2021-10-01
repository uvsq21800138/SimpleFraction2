public class Fraction {
    private int denominateur ;
    private int numerateur ;

    public Fraction(int d, int n) {
        /* cas des divisions par 0 --> NullDivisionException */
        this.denominateur = d;
        this.numerateur = n;
    }

    public int getDen() {
        return denominateur;
    }

    public int getNum() {
        return numerateur;
    }

    public void setDen(int d) {
        this.denominateur = d;
    }

    public void setNum(int n) {
        this.numerateur = n;
    }

    @Override
    public String toString() {
        return "{" + denominateur +
                "/" + numerateur +
                '}';
    }
}
