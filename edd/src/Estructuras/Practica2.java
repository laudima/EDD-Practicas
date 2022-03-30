package edd.src.Estructuras;
import java.lang.Math;

public class Practica2 {

    public static void torresHanoi(int cantidadDiscos,Pila<Integer> origen, Pila<Integer> auxiliar, Pila<Integer> destino){

        //Es el número mínimo de movimientos es 2^n - 1 que haremos
        int total_movientos = (int)Math.pow(2, cantidadDiscos) -1;

        //Agregamos todos los discos al primer pilar (origen)
        for(int i = cantidadDiscos; i>0; i--){
            origen.push(i);
        }

        //Voltea la impresion de la pila para uqe se note el orden de los discos.
        StringBuilder pila = new StringBuilder();
        pila.append(origen.toString());
        pila.reverse();

        //Imprime el estado de inicio
        System.out.println("Tenemos " + cantidadDiscos + " discos");
        System.out.println();
        System.out.println("Movimiento 0");
        System.out.println("===========================================");;
        System.out.println("Pilar origen "+ "\t> " + pila);
        System.out.println("Pilar auxiliar "+ "\t> " + auxiliar.toString());
        System.out.println("Pilar final "+ "\t> " + destino.toString());
        System.out.println("===========================================");

        /*Mueve los discos para hacerlos llegar al pilar de destino.
        dependiendo del movimiento en módulo 3*/
        for(int i=1; i <= total_movientos; i++){

            int movimiento = i % 3;
            int ultimo_disco;

            /*Si la cantidad de discos es impar se intercambian los pilares
            de destino y de origen*/
            if(cantidadDiscos%2==0){
                switch(movimiento){
                    case 1:
                        mueve(origen,auxiliar);
                        break;
                    case 2:
                        mueve(origen, destino);
                        break;
                    case 0:
                        mueve(destino,auxiliar);
                        break;
                }
            }else{
                switch(movimiento){
                    case 1:
                        mueve(origen,destino);
                        break;
                    case 2:
                        mueve(origen, auxiliar);
                        break;
                    case 0:
                        mueve(auxiliar,destino);
                        break;

                }
            }

            /*Voltea el to String de las pilas para que se vea el orden de los
            discos (de mayor a menor)*/
            StringBuilder origen_pila = new StringBuilder();
            origen_pila.append(origen.toString());
            origen_pila.reverse();

            StringBuilder auxiliar_pila = new StringBuilder();
            auxiliar_pila.append(auxiliar.toString());
            auxiliar_pila.reverse();

            StringBuilder destino_pila = new StringBuilder();
            destino_pila.append(destino.toString());
            destino_pila.reverse();

            //Imprime cada movimiento
            System.out.println("Movimiento: " + i);
            System.out.println("Pilar origen" +"\t> " + origen_pila);
            System.out.println("Pilar auxiliar"+"\t> " + auxiliar_pila);
            System.out.println("Pilar final"+ "\t> " + destino_pila);
            System.out.println("=========================================");
        }
    }

    /**
    * Verifica que una pila no este vacía antes de hacer el movimiento,
    * y que se puedan hacer movimietos legales, es decir, no se puede poner
    * un disco grande sobre uno pequeño.
    * @param origen - pila de origen
    * @param destino - pila hacia donde se quieren mover
    */
    private static void mueve(Pila<Integer> origen, Pila<Integer> destino){

        int disco1;
        int disco2;

        /*Si l apila de origen es vacia el disco se mueve de destino -> origen
        si no se mueve de origen -> destino*/
        if(origen.isEmpty()){
            disco1 = destino.pop();
            origen.push(disco1);
        }else if(destino.isEmpty()){
            disco1 = origen.pop();
            destino.push(disco1);
        }else{
            /*Si las dos listas no estan vacías revisa quien es el disco más chico
            y lo cambia de pila */
            disco1 = origen.pop();
            disco2 = destino.pop();
            if(disco1 > disco2){
                origen.push(disco1);
                origen.push(disco2);
            }else{
                destino.push(disco2);
                destino.push(disco1);
            }
        }
    }

    public static void binarioColas(int N){

    }

    public static void main(String[] args) {
        // Escribe aqui tu codigo para probar los metodos anteriores.
        // No olvides comentar tu codigo y escribir tu nombre en el readme.
        int discos =4;

        Pila<Integer> origen = new Pila<Integer>();
        Pila<Integer> auxiliar = new Pila<Integer>();
        Pila<Integer> destino = new Pila<Integer>();

        torresHanoi(discos,origen,auxiliar,destino);

    }

}
