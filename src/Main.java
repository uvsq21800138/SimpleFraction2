public class Main {
    public static void main(String[] argv) {
        System.out.println("Fraction :");
        Fraction f1 = new Fraction(3,4);
        assert f1.toString().equals("{3/4}") : "Erreur dans Fraction.toString";
        System.out.println(f1.toString());
    }
}
