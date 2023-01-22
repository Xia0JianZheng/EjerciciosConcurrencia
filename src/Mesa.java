public class Mesa {

    private String ingrediente1;
    private String ingrediente2;
    private boolean sinIngrediente;

    public Mesa() {
        sinIngrediente = true;
    }

    // Comprueba el estado de variable sinIngrediente, Si es true, el proveedor espera si es false el proveedor
    // genera dos numeros randoms(numero1 : papel / numero2 : tabaco / numero3 : fosforos)
    public synchronized void ponerIngredientes(){
        try {
            while (!sinIngrediente) wait();

            int numIngreRandom = (int) ((Math.random() * 3));
            if (numIngreRandom == 1){
                ingrediente1 = "papel";
            }else if(numIngreRandom == 2){
                ingrediente1 = "tabaco";
            }else{
                ingrediente1 = "fosforos";
            }

            numIngreRandom = (int)((Math.random()*3));
            if (numIngreRandom == 1){
                ingrediente2 = "papel";
            }else if(numIngreRandom == 2){
                ingrediente2 = "tabaco";
            }else{
                ingrediente2 = "fosforos";
            }
            System.out.println("El ingrediente 1 es : " + ingrediente1 + "\nEl ingrediente 2 es : " + ingrediente2);
            sinIngrediente = false;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // comprueba el resulatado de comprobarIngradientes() si da true, print "Nadie Fuma" y pone el variable sinIngrediente = true
    // si da false entra a otro if, si el ingrediente que porta el fumador no es igual que el ingrediente 1 y 2 que pone el proveedor
    // Entonce el fumador enrolla el cigarro y se la fuma, luego pone sinIngrediente a true, si no comple pone el sinIngrediente a false para
    //que otra persona pueda probar.
    public synchronized void fumar(String ingrediente,String nom) {
        try{
            while (sinIngrediente) wait();
            if(comprobarIngredientes()){
                System.out.println("Nadie Fuma");
                sinIngrediente = true;
            }else {
                if(!ingrediente.equals(ingrediente1) && !ingrediente.equals(ingrediente2)){
                    System.out.println("Soy " + nom + " Estoy fumando");
                    sinIngrediente = true;
                }else {
                    sinIngrediente = false;
                }
            }
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //Este metodo comprueba los dos ingredientes que ha traido el peroveedor, si esta repetida retorna true
    // entonce nadie lo fumara, y si da false el programa sigue,
    public boolean comprobarIngredientes(){
        boolean ingredienteRepetida;
        if(ingrediente1.equals(ingrediente2)){
            ingredienteRepetida = true;
        }else{
            ingredienteRepetida = false;
        }
        return ingredienteRepetida;
    }

    public String getIngrediente1() {
        return ingrediente1;
    }

    public void setIngrediente1(String ingrediente1) {
        this.ingrediente1 = ingrediente1;
    }

    public String getIngrediente2() {
        return ingrediente2;
    }

    public void setIngrediente2(String ingrediente2) {
        this.ingrediente2 = ingrediente2;
    }
}
