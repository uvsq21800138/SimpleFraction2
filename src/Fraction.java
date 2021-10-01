public class Fraction {
    private int numerateur ;
    private int denominateur ;

    public Fraction(int n, int d) {
        /* cas des divisions par 0 --> NullDivisionException */
        this.numerateur = n;
        this.denominateur = d;
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
        return "{" + numerateur + "/" + denominateur + "}";
    }
}
