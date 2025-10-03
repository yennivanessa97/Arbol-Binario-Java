import java.util.Scanner;

/**
 * Clase que representa un nodo del árbol binario.
 * Cada nodo contiene un dato de tipo entero y referencias a su hijo izquierdo y derecho.
 */
class Nodo {
    int dato;              // Valor que almacena el nodo
    Nodo izquierda, derecha; // Referencias a los nodos hijos

    /**
     * Constructor del nodo
     */
    public Nodo(int dato) {
        this.dato = dato;
        izquierda = derecha = null; // Inicialmente sin hijos
    }
}

/**
 * Clase que representa un Árbol Binario de Búsqueda.
 * Este Permite insertar valores, recorrer el árbol en orden y buscar elementos.
 */
class ArbolBinario {
    Nodo raiz; // Nodo raíz del árbol

    /**
     * Inserta un nuevo valor en el árbol binario.
     */
    public void insertar(int dato) {
        raiz = insertarRec(raiz, dato);
    }
    /**
     * Inserción recursiva de un nodo en el árbol binario de búsqueda.
     * - Si el árbol está vacío, crea un nuevo nodo.
     * - Si el dato es menor, lo envía al subárbol izquierdo.
     * - Si es mayor, lo envía al subárbol derecho.
     */
    private Nodo insertarRec(Nodo raiz, int dato) {
        if (raiz == null) {
            raiz = new Nodo(dato);
            return raiz;
        }
        if (dato < raiz.dato)
            raiz.izquierda = insertarRec(raiz.izquierda, dato);
        else if (dato > raiz.dato)
            raiz.derecha = insertarRec(raiz.derecha, dato);
        // Si el dato ya existe, no se inserta duplicado
        return raiz;
    }
}
