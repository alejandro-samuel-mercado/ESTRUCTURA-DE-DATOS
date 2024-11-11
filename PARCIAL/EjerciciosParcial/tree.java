package PARCIAL.EjerciciosParcial;

/**
 * Dada la implementación del tipo de dato abstracto Stack o pila que se
 * presenta a continuación a la izquierda (ver cuadro A),
 * Definir los métodos indicados a la derecha (ver cuadro B).
 * En la implementación propuesta se utiliza un arreglo
 * como contenedor de elementos y los elementos se apilan desde el final del
 * arreglo.
 *
 * Cuadro A:
 * public class Stacklnv <ELEMENT> {
 * private final int maximoTamanio = 10;
 * private ELEMENT [ ] datos ;
 * private int cima; //índice cima de la pila
 * public StackKlnv ( ) {
 * this.datos = (ELEMENT [ ]) new Object [this.maximoTamanio];
 * this.cima = datos.length - 1;
 * this.cantidad = 0;
 * }
 * }
 * 
 * Cuadro B:
 * public boolean is Full ( ) // pila llena
 * public void push (ELEMENT elemento)
 * public ELEMENT peek ( )
 **/
public class tree<ELEMENT> {
    private final int maximotamanio = 10;
    private ELEMENT[] datos;
    private int cima;
    private int cantidad;

    @SuppressWarnings("unchecked")
    public tree() {
        this.datos = (ELEMENT[]) new Object[maximotamanio];
        this.cima = datos.length - 1;
        this.cantidad = 0;
    }

    public void push(ELEMENT element) {
        if (isFull()) {
            throw new RuntimeException("Pila llena");
        }
        this.datos[this.cima] = element;
        this.cima--;
        this.cantidad++;
    }

    public ELEMENT peek() {
        if (this.cantidad <= 0) {
            return null;
        }
        ELEMENT elemento = this.datos[this.cima + 1];
        return elemento;
    }

    public boolean isFull() {
        return this.cima < 0;
    }

}
