public class Fumador extends Thread{

    public String ingrediente;

    Mesa mesa;

    public Fumador(String name,String ingredientes, Mesa mesa){
        super(name);
        this.ingrediente = ingredientes;
        this.mesa = mesa;
    }

    @Override
    //El fumador intenta fumar y espera 3000ms
    public void run(){
        for(;;){
                        mesa.fumar(ingrediente,getName());
                        try{
                            Thread.sleep((long) (Math.random() * 3000));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
        }
    }

}
