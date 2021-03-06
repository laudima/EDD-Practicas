package edd.src.Practica1;

import java.util.Iterator;
import java.util.NoSuchElementException;
// iterador
//next

public class Lista<T> implements Collection<T> {

    // Clase Nodo
    private class Nodo {
        public T elemento;
        public Nodo anterior;
        public Nodo siguiente;

        public Nodo(T elemento){
            this.elemento = elemento;
        }
    }

    // Iterador
    private class Iterador implements IteradorLista<T> {
        public Nodo anterior;
        public Nodo siguiente;

        public Iterador(){
            siguiente = cabeza;
        }

        @Override public boolean hasNext(){
            return siguiente != null;
        }

        @Override public T next(){
            if(!hasNext())
                throw new NoSuchElementException();
            T regresar = siguiente.elemento;

            this.anterior = this.siguiente ;
            this.siguiente=siguiente.siguiente;
            return regresar;

        }

        @Override
        public boolean hasPrevious() {
            return anterior != null;
        }

        @Override
        public T previous() {
            if (!hasPrevious())
                throw new NoSuchElementException();
            T regresar = anterior.elemento;

            this.siguiente = this.anterior;
            this.anterior = anterior.anterior;
            return regresar;

        }

        @Override
        public void start(){
            this.anterior = null;
            this.siguiente = cabeza;
        }

        @Override
        public void end() {
            this.anterior = ultimo;
            this.siguiente = null;
        }

    }

    private Nodo cabeza;
    private Nodo ultimo;
    private int longi;

    /**
     * Agrega un elemento a la lista.
     *
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *                                  <code>null</code>.
     */
    @Override
    public void add(T elemento){
        if(elemento == null){
            throw new IllegalArgumentException("El elemento es null");
        }
        agregaFinal(elemento);
    }


    /**
     * Agrega un elemento al inicio de la lista. Si la lista no tiene elementos,
     * el elemento a agregar ser?? el primero y ??ltimo.
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void agregaInicio(T elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("El elemento es null");
        }
        Nodo nuevo = new Nodo(elemento);
        if (cabeza == null) {
            this.cabeza = this.ultimo = nuevo;
        } else {
            this.cabeza.anterior = nuevo;
            nuevo.siguiente = this.cabeza;
            this.cabeza = nuevo;
        }
        longi++;
    }

    /**
     * Agrega un elemento al final de la lista. Si la lista no tiene elementos,
     * el elemento a agregar ser?? el primero y ??ltimo.
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void agregaFinal(T elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("El elemento es null");
        }
        Nodo nuevo = new Nodo(elemento);
        if(cabeza == null){
            this.cabeza = this.ultimo = nuevo;
        }
        else{
            this.ultimo.siguiente = nuevo;
            nuevo.anterior = this.ultimo;
            this.ultimo = nuevo;
        }
        longi++;
    }
    /**
     * Busca el primer nodo con el elemento dado
     * @param elemento el elemento a buscar.
     * @return Nodo - primer nodo con el elemento
     */
    private Nodo buscaElemento(T elemento){
        Nodo n = cabeza;
        while(n !=null){
            if (elemento.equals(n.elemento)) {
                return n;
            }
            n=n.siguiente;
        }
        return null;
    }

    /**
     * Elimina un elemento de la lista.
     *
     * @param elemento el elemento a eliminar.
     */
    public boolean delete(T elemento){
        if(elemento == null)
            return false;
        Nodo n = buscaElemento(elemento);
        if(n==null){
            return false;
        }
        if(longi == 1){
            empty();
            return true;
        }
        if (n == cabeza) {
            cabeza = cabeza.siguiente;
            cabeza.anterior = null;
            longi --;
            return true;
        }
        if (n == ultimo) {
            ultimo = ultimo.anterior;
            ultimo.siguiente = null;
            longi --;
            return true;
        }
        n.siguiente.anterior = n.anterior;
        n.anterior.siguiente = n.siguiente;
        longi --;
        return true;
    }



    /**
     * Regresa un elemento de la lista. (Ultimo)
     * y lo elimina.
     *
     * @return El elemento a sacar.
     */
    public T pop(){
        T valor = ultimo.elemento;
        ultimo = ultimo.anterior;
        ultimo.siguiente = null;
        longi --;
        return valor;
    }

    /**
     * Regresa el n??mero de elementos en la lista.
     *
     * @return el n??mero de elementos en la lista.
     */
    public int size(){
        return longi;
    }

    /**
     * Nos dice si un elemento est?? contenido en la lista.
     *
     * @param elemento el elemento que queremos verificar si est?? contenido en
     *                 la lista.
     * @return <code>true</code> si el elemento est?? contenido en la lista,
     *         <code>false</code> en otro caso.
     */
    public boolean contains(T elemento){
        if(buscaElemento(elemento) == null){
            return false;
        }
        return true;
    }

    /**
     * Vac??a la lista.
     *
     */
    public void empty(){
        cabeza =ultimo= null;
        longi = 0;
    }

    /**
     * Nos dice si la lista es vac??a.
     *
     * @return <code>true</code> si la lista es vac??a, <code>false</code> en
     *         otro caso.
     */
    public boolean isEmpty(){
        return longi == 0;
    }



    /**
     * Regresa una copia de la lista.
     *
     * @return una copia de la lista.
     */
    public Lista<T> clone() {
        Lista<T> nueva = new Lista<T>();
        Nodo nodo = cabeza;
        while (nodo != null) {
            nueva.add(nodo.elemento);
            nodo = nodo.siguiente;
        }
        return nueva;
    }

    /**
     * Nos dice si la coleccion es igual a otra coleccion recibida.
     *
     * @param coleccion la coleccion con el que hay que comparar.
     * @return <tt>true</tt> si la coleccion es igual a la coleccion recibido
     *         <tt>false</tt> en otro caso.
     */
    public boolean equals(Collection<T> coleccion){
        // lo vemos en clase
        if(coleccion instanceof Lista) {
            return true;
        }
        return false;
    }



    /**
     * Metodo que invierte el orden de la lista .
     *
     */
    public void reverse() {
        // Tu codigo aqui
        int index =0;
        int mitad = longi/2;
        //Solo se cambia las referencias de los elementos entonces la memoria,
        //es constante
        Nodo nodoInicio = cabeza;
        Nodo nodoFinal = ultimo;
        //Invierte el orden de los elementos en ambas direcciones, por eso solo
        //hace el ciclo la mitad de la longitud - O(n/2) = O(n)
        while(nodoInicio != null && index<mitad){
            T elementoInicio = nodoInicio.elemento;
            nodoInicio.elemento = nodoFinal.elemento;
            nodoFinal.elemento = elementoInicio;
            nodoInicio = nodoInicio.siguiente;
            nodoFinal = nodoFinal.anterior;
            index++;
        }
    }



    /**
     * Regresa una representaci??n en cadena de la coleccion.
     *
     * @return una representaci??n en cadena de la coleccion.
     * a -> b -> c -> d
     */
    @Override public String toString(){
        // Tu codigo aqui
        if(isEmpty()) return "";

        StringBuilder sb = new StringBuilder();
        //Escribe el primer elemento
        sb.append(cabeza.elemento);

        Nodo nodo = cabeza.siguiente;
        while(nodo!= null){
            sb.append(" -> ");
            sb.append(nodo.elemento);
            nodo = nodo.siguiente;
        }
        return sb.toString();
    }

     /**
     * Junta dos listas siempre y cuando sean del mismo tipo.
     * @param Lista a anexar
     */
    public void append(Lista<T> lista) {
        if (lista.isEmpty()){
            return;
        }
        Nodo nodo = lista.cabeza;
        while(nodo != null){
            add(nodo.elemento);
            nodo = nodo.siguiente;
        }
        longi += lista.size();
        return;
    }

    /**
     * Regresa un entero con la posicion del elemento.
     * Solo nos importara la primera aparici??n del elemento
     * Empieza a contar desde 0.
     *
     * @param elemento elemento del cual queremos conocer la posici??n.
     * @return entero con la posicion del elemento
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     * @throws NoSuchElementException si <code>lista</code> es <code>vacia</code>
     */
    public int indexOf(T elemento) {
        // Tu codigo aqui
        if(elemento == null){
            throw new IllegalArgumentException("No se puso elemento");
        }
        if(isEmpty()){
            throw new NoSuchElementException("La lista es vac??a");
        }
        int index = 0;
        Nodo nodo = cabeza;
        while(elemento != nodo.elemento && nodo != null){
            index++;
            nodo = nodo.siguiente;
            if(index == longi-1){
                return -1;
            }
        }
        return index;

    }

    /**
     * Inserta un elemento en un ??ndice expl??cito.
     *
     * Si el ??ndice es menor que cero, el elemento se agrega al inicio de la
     * lista. Si el ??ndice es mayor o igual que el n??mero de elementos en la
     * lista, el elemento se agrega al fina de la misma. En otro caso, despu??s
     * de mandar llamar el m??todo, el elemento tendr?? el ??ndice que se
     * especifica en la lista.
     *
     * @param i        el ??ndice d??nde insertar el elemento. Si es menor que 0 el
     *                 elemento se agrega al inicio, y si es mayor o igual que el
     *                 n??mero
     *                 de elementos en la lista se agrega al final.
     * @param elemento el elemento a insertar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *                                  <code>null</code>.
     */
    public void insert(int i, T elemento) {
        // Tu codigo aqui
        if(elemento == null){
            throw new IllegalArgumentException("El elemento es vac??o");
        }
        if(i<=0){
            agregaInicio(elemento);
        }else if(i >= longi-1){
            agregaFinal(elemento);
        }else{
            Nodo nuevo = new Nodo(elemento);
            Nodo nodo1 = cabeza.siguiente;
            Nodo nodo2 = cabeza;
            int index = 0;
            //hacemos el ciclo hasta el indice anterior al que queremos
            //porque llegamos a la ubicacion del nodo anterior al nuevo
            while(nodo1 != null && index!=i-1){
                nodo1 = nodo1.siguiente;
                nodo2 = nodo1.anterior;
                index++;
            }
            if(index == i-1){
                nodo2.siguiente = nuevo;
                nuevo.anterior = nodo2;
                nuevo.siguiente = nodo1;
                nodo1.anterior = nuevo;
            }
        }
        longi++;
        return;
    }

     // Tu comentario
     public void mezclaAlternada(Lista<T> lista){
         /*Solo cambiamos las referencias sin crear mas nodos, entonces
         el tama??o es constante*/
        Nodo actual1 = cabeza;
        Nodo actual2 = lista.cabeza;
        Nodo next1,next2;

        //recorremos n+m nodos -> O(n+m)
        while(actual1 != null && actual2 != null){
            //guardamos las referencias al siguiente
            next1 = actual1.siguiente;
            next2 = actual2.siguiente;

            //ponemos el siguiente de la lista 2 y luego lo agregammos a la lista 1
            actual2.siguiente = next1;
            actual1.siguiente = actual2;

            //pasamos a los siguientes nodos
            actual1 = next1;
            actual2 = next2;
        }
        longi += lista.size();
        return;
    }

    public T get(int index){
        Nodo aux = cabeza;
        int index_actual=0;
        if(index==0){
            return cabeza.elemento;
        }
        while(index_actual!=index){
            aux = aux.siguiente;
            index_actual++;
        }
        return aux.elemento;
    }

    /**
     * Regresa un iterador para recorrer la lista en una direcci??n.
     * @return un iterador para recorrer la lista en una direcci??n.
     */
    public Iterator<T> iterator() {
        return new Iterador();
    }

    /**
     * Regresa un iterador para recorrer la lista en ambas direcciones.
     * @return un iterador para recorrer la lista en ambas direcciones.
     */
    public IteradorLista<T> iteradorLista() {
        return new Iterador();
    }
}
