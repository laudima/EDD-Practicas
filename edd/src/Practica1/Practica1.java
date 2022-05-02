package edd.src.Practica1;


public class Practica1 {
    

    /**
     * Método que agrega un elemento de manera ordenada a una lista previamente ordenada.
     * @param lista lista a la que se agregará el elemento "nuevo"
     * @param nuevo elemento a agregar en la lista ordenada
     * @return lista
     */
    public static Lista<Integer> AgregaOrdenado(Lista<Integer> lista, int nuevo) {
        //Tu codigo aqui
        if (lista.isEmpty()){
            lista.add(nuevo);
        }else{
            //lista.insert(i, elemento)
            IteradorLista<Integer> i = lista.iteradorLista();
            i.start();
            int index_tracker = 0;
            while(i.hasNext()){
                int index =(int) i.next();
                if(index <= nuevo){
                    index_tracker++;
                }else{
                    break;
                }
            }
            if(index_tracker == 0){
                lista.agregaInicio(nuevo);
            }else if(index_tracker >= lista.size()){
                lista.agregaFinal(nuevo);
            }else{
                lista.insert(index_tracker-1, nuevo);
            }
        }
        return lista;
    }

    /**
     * Método para hacer la unión de dos listas, eliminando los repetidos en ellas. El tiempo
     * de ejecución de este método está dado por O(n*m) pues recorre la lista2 de m elementos
     * n veces.
     * Este método podría mejorarse utilizando la estructura de datos set, pues esta no permitiría la entrada
     * de elementos repetidos y su complejidad se vería mejorada a O(m+n) pues en el peor de los casos no existen
     * repetidos en las dos listas y se recorrería tanto m como n para insertarlos dentro del stack.
     * @param lista1 lista que se unirá con lista2
     * @param lista2 lista que se unirá con lista1
     */
    public static void Union(Lista<Integer> lista1,Lista<Integer> lista2) {
        IteradorLista<Integer> i = lista1.iteradorLista();
        IteradorLista<Integer> j = lista2.iteradorLista();
        i.start(); //Arrrrrancaaaan 
        while (i.hasNext()){ //n repeticiones 
            Boolean repetido = false;
            int index = (int) i.next();
            j.start();
            while(j.hasNext()){ //m repeticiones en cada n-vuelta
                int jindex = (int) j.next(); //jeje jindex
                if (index == jindex){
                    repetido = true;
                    break; 
                }
            }
            if (!repetido){
                lista2.add(index);
            }
        }
        return; 
    }

    /**
     * Método para determinar la intersección entre dos listas y guardarla dentro de la primera lista.
     * Este método es practicamente igual que el método Unión, difiriendo unicamente en que se mantienen
     * los elementos repetidos y se borran los elementos únicos dentro de lista, dejando de lado también 
     * los elementos únicos de lista2. 
     * Al igual que Unión, este método podría mejorar su complejidad utilizando la estructura de datos set,
     * pues con ella podríamos determinar cuáles son los elementos únicos de nuestras dos listas, hacer unión
     * de estas y eliminar todo elemento que se encuentre en el set.
     * @param lista
     * @param lista2
     */
    public static void Interseccion(Lista<Integer> lista,Lista<Integer> lista2) {
        IteradorLista<Integer> i = lista.iteradorLista();
        IteradorLista<Integer> j = lista2.iteradorLista();
        i.start(); //Arrrrrancaaaan 
        while (i.hasNext()){ //n repeticiones 
            Boolean repetido = false;
            int index = (int) i.next();
            j.start();
            while(j.hasNext()){ //m repeticiones en cada n-vuelta
                int jindex = (int) j.next(); //jeje jindex
                if (index == jindex){
                    repetido = true;
                    break; 
                }
            }
            if (!repetido){
                lista.delete(index);
            }
        }
        return; 
    }



    public static void main(String[] args) {
        Lista<Integer> primera = new Lista<Integer>();
        Lista<Integer> segunda = new Lista<Integer>();
        Lista<Integer> tercera = new Lista<Integer>();
        
        
        // Tests toString
        for (int i = 0; i <= 5; i++) {
            primera.add(i);
        }
        
        String test = "0 -> 1 -> 2 -> 3 -> 4 -> 5";
        if (!primera.toString().equals(test)) {
            System.out.println("1 El toString no funciona!");
        }
        primera = new Lista<Integer>();
        if (!primera.toString().equals("")) {
            System.out.println("2 El toString no funciona!");
        }
            
        // Tests Reverse
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();

        for (int i = 0; i <= 10; i++) {
            primera.add(i);
            segunda.agregaInicio(i);
        }
      
        primera.reverse();
        if (!primera.toString().equals(segunda.toString())) {
            System.out.println("1 El reverse no funciona!");    
        }
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();
        primera.reverse();
        if (!primera.toString().equals(segunda.toString())) {
            System.out.println("2 El reverse no funciona!");
        }

        // Tests Append
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();
        for (int i = 0; i <= 10; i++) {
            primera.add(i);
            segunda.add(i);
        }
        for (int i = 0; i <= 10; i++) {
            segunda.add(i);
        }
        primera.append(primera.clone());

        
        if (!primera.toString().equals(segunda.toString())) {
            System.out.println("1 El Append no funciona!");
        }

        // Tests IndexOf
        if (primera.indexOf(0) != 0) {
            System.out.println("1 El IndexOf no funciona!");
        }
        if (primera.indexOf(1) != 1) {
            System.out.println("2 El IndexOf no funciona!");
        }
        if (primera.indexOf(10) != 10) {
            System.out.println("3 El IndexOf no funciona!");
        }

        // Tests Insert
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();
        for (int i = 0; i <= 10; i++) {
            primera.add(i);
            
        }
        for (int i = 0; i <= 4; i++) {
            segunda.add(i);

        }
        segunda.add(6);
        for (int i = 5; i <= 10; i++) {
            segunda.add(i);

        }

        primera.insert(5, 6);
        if (!primera.toString().equals(segunda.toString())) {
            System.out.println("1 El insert no funciona!");
        }

        // Tests Mezcla Alternada
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();
        for (int i = 0; i <= 10; i++) {
            if (i % 2 == 0) {
                primera.add(i);
            }   
        }
        primera.add(11);
        for (int i = 0; i <= 10; i++) {
            if (i % 2 != 0) {
                segunda.add(i);
            }

        }
        for (int i = 0; i <= 11; i++) {
            
                tercera.add(i);

        }


        primera.mezclaAlternada(segunda);
        if (!primera.toString().equals(tercera.toString())) {
            System.out.println("1 la mezclaAlternada no funciona!");
        }


        // Tests Agrega Ordenado
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();
        for (int i = 0; i <= 10; i++) {
            primera.add(i);
        }
        for (int i = 0; i <= 9; i++) {
            segunda.add(i);
        }
        segunda.add(9);
        segunda.add(10);
        
        
        tercera = AgregaOrdenado(primera,9);
        if (!tercera.toString().equals(segunda.toString())) {
            System.out.println("1 el agregaOrdenado no funciona!");
        }
        
        // Tests Union
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();
        tercera = new Lista<Integer>();
        primera.add(1);
        primera.add(2);
        primera.add(3);
        segunda.add(2);
        Union(primera, segunda);

        if (!(primera.contains(1) && primera.contains(2) && primera.contains(3) && primera.size() == 3)) {
            System.out.println("1 La union no funciona!");
        }
        
        // Tests interseccion
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();
        tercera = new Lista<Integer>();
        primera.add(1);
        primera.add(2);
        primera.add(3);
        segunda.add(2);
        Interseccion(primera, segunda);

        if (!(primera.contains(2) && primera.size() == 1)) {
            System.out.println("1 La intersección no funciona!");
        }
        
        



    }   
   

    


}
