package tp.practica2.ejercicio1y2;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {
    private T data;
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;

    public BinaryTree() {
    }

    public BinaryTree(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTree<T> getLeftChild() {
        return this.leftChild;
    }

    public BinaryTree<T> getRightChild() {
        return this.rightChild;
    }

    public void addLeftChild(BinaryTree<T> child) {
        this.leftChild = child;
    }

    public void addRightChild(BinaryTree<T> child) {
        this.rightChild = child;
    }

    public void removeLeftChild() {
        this.leftChild = null;
    }

    public void removeRightChild() {
        this.rightChild = null;
    }

    public boolean isEmpty() {
        return this.isLeaf() && this.getData() == null;
    }

    public boolean isLeaf() {
        return !this.hasLeftChild() && !this.hasRightChild();
    }

    public boolean hasLeftChild() {
        return this.leftChild != null;
    }

    public boolean hasRightChild() {
        return this.rightChild != null;
    }

    public String toString() {
        return this.getData().toString();
    }

    public int contarHojas() {
        int leftC = 0;
        int rightC = 0;

        if (this.isEmpty())
            return 0;
        if (this.isLeaf())
            return 1;

        if (this.hasLeftChild())
            leftC = this.getLeftChild().contarHojas();
        if (this.hasRightChild())
            rightC = this.getRightChild().contarHojas();

        return leftC + rightC;
    }

    public BinaryTree<T> espejo() {
        BinaryTree<T> arbEspejo = new BinaryTree(this.getData());
        if (this.hasLeftChild()) {
            arbEspejo.addRightChild(this.getLeftChild().espejo());
        }

        if (this.hasRightChild()) {
            arbEspejo.addLeftChild(this.getRightChild().espejo());
        }

        return arbEspejo;
    }

    public void entreNiveles(int n, int m) {
        if (!this.isEmpty() && n >= 0 && m >= n) {
            Queue<BinaryTree<T>> cola = new LinkedList();
            cola.add(this);
            int nivelActual = 0;

            while (!cola.isEmpty()) {
                int nodoNivel = cola.size();
                int i;
                if (nivelActual >= n && nivelActual <= m) {
                    for (i = 0; i < nodoNivel; ++i) {
                        BinaryTree<T> nodo = cola.remove();
                        System.out.print(nodo.getData() + " | ");
                        if (nodo.hasLeftChild()) {
                            cola.add(nodo.getLeftChild());
                        }
                        if (nodo.hasRightChild()) {
                            cola.add(nodo.getRightChild());
                        }
                    }
                } else {
                    for (i = 0; i < nodoNivel; ++i) {
                        cola.remove();
                    }
                }

                ++nivelActual;
                System.out.println("");
            }

        }
    }

    public void imprimirArbol() {
        if (this.hasLeftChild())
            this.getLeftChild().imprimirArbol();
        System.out.print(this.getData() + " ");
        if (this.hasRightChild())
            this.getRightChild().imprimirArbol();

    }

    public static void main(String[] args) {
        System.out.println("Test metodos Arboles");
        BinaryTree<Integer> ab = new BinaryTree(4);
        ab.addLeftChild(new BinaryTree(2));
        ab.addRightChild(new BinaryTree(6));
        ab.getLeftChild().addLeftChild(new BinaryTree(1));
        ab.getLeftChild().addRightChild(new BinaryTree(3));
        ab.getRightChild().addLeftChild(new BinaryTree(5));

        /*System.out.println(ab.contarHojas());
        System.out.println("Arbol original: ");
        ab.imprimirArbol();
        System.out.println("Arbol espejo: ");
        BinaryTree<Integer> abEspejo = ab.espejo();
        abEspejo.imprimirArbol();
        */
        System.out.println("Impresion Arbol por niveles 0 y 1");
        ab.entreNiveles(0, 2);
    }
}
