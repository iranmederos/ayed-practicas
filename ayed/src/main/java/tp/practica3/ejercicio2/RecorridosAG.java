package tp.practica3.ejercicio2;

import tp.practica1.Queue;
import tp.practica3.ejercicio1.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class RecorridosAG {
    public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n) {

        List<Integer> listaElementos = new LinkedList<Integer>();
        recorridoNumerosImparesMayoresQuePreOrden(listaElementos, n, a);
        return listaElementos;

    }

    private void recorridoNumerosImparesMayoresQuePreOrden(List<Integer> lista, Integer n, GeneralTree<Integer> a) {
        if ((a.getData() > n) && (a.getData() % 2 != 0))
            lista.add(a.getData());
        if (a.hasChildren()) {
            List<GeneralTree<Integer>> children = a.getChildren();
            for (GeneralTree<Integer> child : children) {
                recorridoNumerosImparesMayoresQuePreOrden(lista, n, child);
            }
        }
    }

    public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree<Integer> a, Integer n) {
        List<Integer> listaElementos = new LinkedList<Integer>();
        recorridoNumerosImparesMayoresQueInOrden(listaElementos, n, a);
        return listaElementos;
    }

    private void recorridoNumerosImparesMayoresQueInOrden(List<Integer> lista, Integer n, GeneralTree<Integer> a) {
        List<GeneralTree<Integer>> children = a.getChildren();
        if (children != null) {
            recorridoNumerosImparesMayoresQueInOrden(lista, n, children.get(0));
            if ((a.getData() > n) && (a.getData() % 2 != 0))
                lista.add(a.getData());
            for (int i = 1; i < children.size(); i++) {
                recorridoNumerosImparesMayoresQueInOrden(lista, n, children.get(i));
            }
        }
    }

    public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a, Integer n) {
        List<Integer> listaElementos = new LinkedList<Integer>();
        recorridoNumerosImparesMayoresQuePostOrden(listaElementos, n, a);
        return listaElementos;
    }

    private void recorridoNumerosImparesMayoresQuePostOrden(List<Integer> lista, Integer n, GeneralTree<Integer> a) {
        if (a.hasChildren()) {
            List<GeneralTree<Integer>> children = a.getChildren();
            for (GeneralTree<Integer> child : children) {
                recorridoNumerosImparesMayoresQuePostOrden(lista, n, child);
            }
        }
        if ((a.getData() > n) && (a.getData() % 2 != 0))
            lista.add(a.getData());
    }

    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, Integer n) {
        List<Integer> listaElementos = new LinkedList<Integer>();
        recorridoNumerosImparesMayoresQuePorNiveles(listaElementos, n, a);
        return listaElementos;
    }

    private void recorridoNumerosImparesMayoresQuePorNiveles(List<Integer> lista, Integer n, GeneralTree<Integer> a) {
        GeneralTree<Integer> tree_aux;
        Queue<GeneralTree<Integer>> queue = new Queue<>();
        queue.enqueue(a);
        while (!queue.isEmpty()) {
            tree_aux = queue.dequeue();
            if ((a.getData() > n) && (a.getData() % 2 != 0)) {
                lista.add(tree_aux.getData());
            }
            if (tree_aux.hasChildren()) {
                List<GeneralTree<Integer>> children = tree_aux.getChildren();
                for (GeneralTree<Integer> child : children) {
                    queue.enqueue(child);
                }
            }
        }
    }
}
