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
     * @param dato Valor entero que contendrá este nodo
     */
    public Nodo(int dato) {
        this.dato = dato;
        izquierda = derecha = null; // Inicialmente sin hijos
    }
}
