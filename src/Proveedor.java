import java.util.concurrent.ThreadLocalRandom;

public class Proveedor extends Thread{
    Mesa mesa;
    public Proveedor(String name, Mesa mesa) {
        super(name);
        this.mesa = mesa;
    }

    @Override
    //El proveedor pone ingrediente y espera 3000ms
    public void run(){
        for(;;){
            System.out.println("Soy Ramon y estas son los dos ingredientes que os traigo : ");
            mesa.ponerIngredientes();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
