public class Main {
    public static void main(String[] argv) {
        System.out.println("Fraction :");
        Fraction f1 = new Fraction(3,4);
        assert f1.getDen() == 4 : "Erreur du Denominateur";
        assert f1.getNum() == 3 : "Erreur Du Numerateur";
        assert f1.toString().equals("{3/4}") : "Erreur dans Fraction.toString";
        System.out.println(f1.toString());
        f1.setDen(1);
        f1.setNum(5);
        assert f1.toString().equals("{5/1}") : "Erreur dans Fraction.toString";
        System.out.println(f1.toString());
    }
}
