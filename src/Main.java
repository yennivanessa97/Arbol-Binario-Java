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
    /**
     * Muestra el recorrido inorder del árbol.
     * El recorrido inorden imprime los valores en orden ascendente.
     */
    public void inorden() {
        inordenRec(raiz);
        System.out.println();
    }

    /**
     * Método recursivo para realizar el recorrido inorden:
     */
    private void inordenRec(Nodo raiz) {
        if (raiz != null) {
            inordenRec(raiz.izquierda);
            System.out.print(raiz.dato + " ");
            inordenRec(raiz.derecha);
        }
    }

    /**
     * Busca un valor dentro del árbol.
     * param dato número entero a buscar
     * return true si existe, false si no
     */
    public boolean buscar(int dato) {
        return buscarRec(raiz, dato);
    }

    /**
     * Búsqueda recursiva en el árbol:
     * - Retorna true si encuentra el dato
     * - Retorna false si llega a un nodo nulo
     */
    private boolean buscarRec(Nodo raiz, int dato) {
        if (raiz == null) {
            return false; // Árbol vacío o no encontrado
        }
        if (dato == raiz.dato) {
            return true; // Encontrado
        }
        // Busca en el subárbol correspondiente
        return dato < raiz.dato
                ? buscarRec(raiz.izquierda, dato)
                : buscarRec(raiz.derecha, dato);
    }
}

/**
 * Clase principal del programa.
 * Muestra un menú en consola para interactuar con el árbol binario:
 * 1. Insertar números
 * 2. Mostrar recorrido inorden
 * 3. Buscar un número
 * 4. Salir
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);   // Para leer datos de consola
        ArbolBinario arbol = new ArbolBinario(); // Crear árbol vacío
        int opcion, numero;

        do {
            // Menú de opciones
            System.out.println("\n  MENÚ ÁRBOL BINARIO ");
            System.out.println("1. Insertar número");
            System.out.println("2. Mostrar recorrido inorden");
            System.out.println("3. Buscar número");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa número a insertar: ");
                    numero = sc.nextInt();
                    arbol.insertar(numero);
                    System.out.println("Número insertado.");
                    break;
                case 2:
                    System.out.println("Recorrido inorden: ");
                    arbol.inorden();
                    break;
                case 3:
                    System.out.print("Ingresa número a buscar: ");
                    numero = sc.nextInt();
                    if (arbol.buscar(numero))
                        System.out.println("Número encontrado ");
                    else
                        System.out.println("El número no existe ");
                    break;
                case 4:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);
        sc.close(); // Cierra el Scanner
    }

}

