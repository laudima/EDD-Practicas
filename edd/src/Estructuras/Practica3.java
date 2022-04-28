package edd.src.Estructuras;
public class Practica3 {
    
    public static void sumaCercana(Lista<Integer> lista,int N){

    }
    public static void permutacionesCadena(String cadena){

    }
    public static void primosQueSuman(int S, int P, int N){

    }
    public static void N_Reinas(int N){

    }

    public static void main(String[] args) {
        //Puedes hacer tus pruebas aqui
        Lista<Integer> lista = new Lista<Integer>();
        for(int i=0; i<11;i++){
            lista.add(i);
        }
        ArbolBinarioOrdenado<Integer> arbolito = new ArbolBinarioOrdenado<>(lista, true);
        System.out.println(arbolito.toString(arbolito.raiz()));
    }

}
