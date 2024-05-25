package tp.practica3.ejercicio1y2y3y5;

import tp.practica1.Queue;
import tp.practica3.ejercicio4.AreaEmpresa;

import java.util.LinkedList;
import java.util.List;

public class GeneralTree<T> {

    private T data;
    private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>();

    public GeneralTree() {

    }

    public GeneralTree(T data) {
        this.data = data;
    }

    public GeneralTree(T data, List<GeneralTree<T>> children) {
        this(data);
        this.children = children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<GeneralTree<T>> getChildren() {
        return this.children;
    }

    public void setChildren(List<GeneralTree<T>> children) {
        if (children != null)
            this.children = children;
    }

    public void addChild(GeneralTree<T> child) {
        this.getChildren().add(child);
    }

    public boolean isLeaf() {
        return !this.hasChildren();
    }

    public boolean hasChildren() {
        return !this.children.isEmpty();
    }

    public boolean isEmpty() {
        return this.data == null && !this.hasChildren();
    }

    public void removeChild(GeneralTree<T> child) {
        if (this.hasChildren())
            children.remove(child);
    }

    public int altura() {
        int altura = 0;
        int aux = 0;
        if (!this.hasChildren())
            return altura;
        for (GeneralTree<T> child : this.getChildren()) {
            aux += child.altura();
            if (aux > altura) {
                altura = aux;
                aux = 0;
            }
        }
        return altura++;
    }

    public int nivel(T dato) {
        if (!this.isEmpty()) {
            int level = 0;
            int queueSize;
            GeneralTree<T> currentNodo;
            Queue<GeneralTree<T>> cola = new Queue<>();
            cola.enqueue(this);
            while (!cola.isEmpty()) {
                queueSize = cola.size();
                for (int i = 0; i < queueSize; ++i) {
                    currentNodo = cola.dequeue();
                    if (currentNodo.getData().equals(dato))
                        return level;
                    else
                        for (GeneralTree<T> child : currentNodo.getChildren())
                            cola.enqueue(child);
                }
                level++;
            }
            return -1;
        } else
            return -1;
    }

    public int ancho() {
        if (!this.isEmpty()) {
            int size = 0;
            int queueSize;
            GeneralTree<T> currentNodo;
            Queue<GeneralTree<T>> cola = new Queue<>();
            cola.enqueue(this);
            while (!cola.isEmpty()) {
                queueSize = cola.size();
                for (int i = 0; i < queueSize; ++i) {
                    size = Math.max(size, queueSize);
                    currentNodo = cola.dequeue();
                    if (currentNodo.hasChildren())
                        for (GeneralTree<T> child : currentNodo.getChildren())
                            cola.enqueue(child);
                }
            }
            return size;
        } else
            return 0;
    }

	/* Ejercicio2
	b) Si ahora tuviera que implementar estos métodos en la clase GeneralTree<T>, ¿qué modificaciones
	haría tanto en la firma como en la implementación de los mismos? */

    public List<Integer> numerosImparesMayoresQuePreOrden(Integer n) {
        List<Integer> l = new LinkedList<Integer>();
        if (!this.isEmpty()) this.numerosImparesMayoresQuePreOrden(n, l);
        return l;
    }

    private void numerosImparesMayoresQuePreOrden(Integer n, List<Integer> l) {
        int dato = (Integer) this.getData();
        if (dato % 2 != 0 && dato > n) l.add(dato);
        List<GeneralTree<T>> children = this.getChildren();
        for (GeneralTree<T> child : children) {
            child.numerosImparesMayoresQuePreOrden(n, l);
        }
    }

    public List<Integer> numerosImparesMayoresQueInOrden(Integer n) {
        List<Integer> l = new LinkedList<Integer>();
        if (!this.isEmpty()) this.numerosImparesMayoresQueInOrden(n, l);
        return l;
    }

    private void numerosImparesMayoresQueInOrden(Integer n, List<Integer> l) {
        List<GeneralTree<T>> children = this.getChildren();
        if (this.hasChildren()) {
            children.get(0).numerosImparesMayoresQueInOrden(n, l);
        }
        int dato = (Integer) this.getData();
        if (dato % 2 != 0 && dato > n) l.add(dato);
        for (int i = 1; i < children.size(); i++) {
            children.get(i).numerosImparesMayoresQueInOrden(n, l);
        }
    }

    public List<Integer> numerosImparesMayoresQuePostOrden(Integer n) {
        List<Integer> l = new LinkedList<Integer>();
        if (!this.isEmpty()) this.numerosImparesMayoresQuePostOrden(n, l);
        return l;
    }

    private void numerosImparesMayoresQuePostOrden(Integer n, List<Integer> l) {
        List<GeneralTree<T>> children = this.getChildren();
        for (GeneralTree<T> child : children) {
            child.numerosImparesMayoresQuePostOrden(n, l);
        }
        int dato = (Integer) this.getData();
        if (dato % 2 != 0 && dato > n) l.add(dato);
    }

    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<T> a, Integer n) {
        List<Integer> result = new LinkedList<>();
        GeneralTree<T> aux;
        Queue<GeneralTree<T>> queue = new Queue<>();
        queue.enqueue(a);
        while (!queue.isEmpty()) {
            aux = queue.dequeue();
            if (!aux.isEmpty()) {
                int dato = (Integer) this.getData();
                if (dato % 2 != 0 && dato > n) result.add(dato);
            }
            List<GeneralTree<T>> children = aux.getChildren();
            for (GeneralTree<T> child : children) {
                queue.enqueue(child);
            }
        }
        return result;
    }

    //ejercicio 5
    public boolean esAncestro(T a, T b) {
        boolean esAncestro = false;
        GeneralTree<T> aTree = finder(a, this);
        GeneralTree<T> bTree = null;
        if (aTree != null)
            bTree = finder(b, aTree);
        if (!(aTree == null) && !(bTree == null)) {
            esAncestro = true;
        }
        return esAncestro;
    }

    public GeneralTree<T> finder(T dato, GeneralTree<T> tree) {
        if (tree.getData().equals(dato))
            return tree;

        GeneralTree<T> aux = null;
        if (tree.hasChildren()) {
            List<GeneralTree<T>> children = tree.getChildren();
            for (GeneralTree<T> child : children) {
                if (child.getData().equals(dato)) {
                    aux = child;
                    break;
                }
                aux = child.finder(dato, child);
                if (aux != null)
                    return aux;
            }
        }
            return aux;
        }

    }