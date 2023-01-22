public class Main {
    public static void main(String[] args) {

        Mesa mesa = new Mesa();

        Fumador joanet = new Fumador("Joanet", "papel", mesa);
        Fumador marieta = new Fumador("Marieta", "tabaco", mesa);
        Fumador ciscu = new Fumador("ciscu", "fosforos", mesa);

        Proveedor ramon = new Proveedor("Ramon", mesa);

        ramon.start();
        joanet.start();
        marieta.start();
        ciscu.start();
    }
}