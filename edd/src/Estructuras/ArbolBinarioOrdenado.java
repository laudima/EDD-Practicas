package edd.src.Estructuras;
//import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArbolBinarioOrdenado<T extends Comparable<T>> extends ArbolBinario<T> {
    
    /* Clase privada para iteradores de árboles binarios ordenados. */
    private class Iterador implements Iterator<T>{
        private Pila<Vertice> pila;

        public Iterador(){
            pila = new Pila<Vertice>();
            Vertice p = raiz;
            while (p!= null) {
                pila.push(p);
                p = p.izquierdo;    
            }
        }

        /* Nos dice si hay un elemento siguiente. */
        public boolean hasNext(){
            return !pila.isEmpty();
        }

        public T next(){
            if(pila.isEmpty()){
                throw new NoSuchElementException("vacio");
            }
            Vertice v = pila.pop();
            if(v.izquierdo != null)
                pila.push(v.izquierdo);
            if(v.derecho != null)
                pila.push(v.derecho);   
            return v.elemento;
        }
    }

    public ArbolBinarioOrdenado(Lista<T> lista, boolean isSorted ){
        if (isSorted) {
            raiz = buildSorted(lista);
            elementos = lista.size();
        }
        // else{
        //     raiz = buildUnsorted(lista);
        //     elementos = lista.size();
        // }
    }
    /**
     * Funcion para construir un arbol apartir de una lista ordenada
     * @param lista
     * @return root
     */
    public Vertice buildSorted(Lista<T> lista){ 
        int izq=0; 
        int der=lista.size()-1;
        IteradorLista<T> iter = lista.iteradorLista();
        Vertice root = auxbuildSorted(iter,izq,der);
        return root;
    }

    /**
     * Primero sacamos el elemento a la indix de la mitad, 
     * construimos recursivamente todos los arboles a la izquierda,
     * pasamos al sigueinte de la raiz, y contruimos recursivamente todos los
     * elementos a la derecha.
     * Vemos que la complejidad de 
     * O(auxbuildSorted(n)) = O(1) + O(auxbuildSorted(n/2)) + O(auxbuildSorted(n/2))
     * O(auxbuildSorted(n/2)) = 0(1) +  O(auxbuildSorted(n/4)) + O(auxbuildSorted(n/4))
     * ...
     * O(auxbuildSorted(n)) = O(1) + O(n) = O(n)
     * 
     * @param iter - iterador para movernos sobre la cabeza de la lista
     * @param izq - index más a izquierda
     * @param der - index mas a la derecha
     * @return root
     */
    private Vertice auxbuildSorted(IteradorLista<T> iter, int izq, int der){
        int mid;
        if(izq > der){
            return null;
        }
        mid = (izq + der)/2;
        raiz.izquierdo = auxbuildSorted(iter, izq, mid-1);
        raiz.elemento = iter.next();
        raiz.derecho = auxbuildSorted(iter, mid+1, der);
        return raiz;
    }

    // public Vertice buildUnsorted(Lista<T> lista){
        
    // }
    
    public void add(T elemento){

    }
    public boolean delete(T elemento){
        return true;
    }

    public String toString(VerticeArbolBinario<T> root){
        Iterador iter = new Iterador();
        String rep="";
        while(iter.hasNext()){
            rep += iter.next() + " ";
        }
        return rep;
    }

    /**
     * Regresa un iterador para iterar el árbol. El árbol se itera en orden DFS.
     * 
     * @return un iterador para iterar el árbol.
     */
    public Iterator<T> iterator() {
        return new Iterador();
    }

}
