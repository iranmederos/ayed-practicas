package tp.practica3.ejercicio10;

import tp.practica3.ejercicio1y2y3y5.GeneralTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import tp.practica1.Queue;

public class ParcialArboles {

    public static List<Integer> resolver(GeneralTree<Integer> arbol) {
        List<Integer> resultados;
        List<GeneralTree<Integer>> pathMax = new LinkedList<>();
        List<GeneralTree<Integer>> currentPath = new LinkedList<>();
        pathUntilLeaf(arbol, pathMax, currentPath, 0, 0);
        resultados = pathMax.stream().map(GeneralTree::getData).filter(n -> n != 0).toList();
        return resultados;
    }

    public static void pathUntilLeaf(GeneralTree<Integer> nodo, List<GeneralTree<Integer>> pathMax,
                                                    List<GeneralTree<Integer>> currentPath, int cuenta, int level) {
        int cuentaActual = cuenta;
        if (nodo != null) {
            currentPath.add(nodo);
            cuentaActual += nodo.getData() * level;
            if (!nodo.isLeaf()) {
                for (GeneralTree<Integer> child : nodo.getChildren()) {
                    pathUntilLeaf(child, pathMax, currentPath, cuentaActual, level + 1);
                }
            }
        }
        if (nodo != null && nodo.isLeaf() && currentPath.size() > pathMax.size()) {
            if (cuenta < cuentaActual) {
                pathMax.clear();
                pathMax.addAll(currentPath);
            }
        }
        currentPath.remove(nodo);
    }


    public static void main(String[] args) {
        GeneralTree<Integer> arbol1 = new GeneralTree<>(1);//raiz
        GeneralTree<Integer> arbol2 = new GeneralTree<>(0);
        GeneralTree<Integer> arbol3 = new GeneralTree<>(1);
        GeneralTree<Integer> arbol4 = new GeneralTree<>(1);

        arbol1.setChildren(Arrays.asList(arbol2, arbol3, arbol4));

        GeneralTree<Integer> arbol5 = new GeneralTree<>(1);
        GeneralTree<Integer> arbol6 = new GeneralTree<>(1);

        arbol2.setChildren(Arrays.asList(arbol5, arbol6));

        GeneralTree<Integer> arbol7 = new GeneralTree<>(1);
        GeneralTree<Integer> arbol8 = new GeneralTree<>(0);

        arbol3.setChildren(Arrays.asList(arbol7, arbol8));

        GeneralTree<Integer> arbol9 = new GeneralTree<>(0);

        arbol4.setChildren(List.of(arbol9));

        GeneralTree<Integer> arbol10 = new GeneralTree<>(1);
        GeneralTree<Integer> arbol11 = new GeneralTree<>(1);
        GeneralTree<Integer> arbol12 = new GeneralTree<>(1);

        arbol5.setChildren(Arrays.asList(arbol10, arbol11, arbol12));

        GeneralTree<Integer> arbol13 = new GeneralTree<>(0);

        arbol8.setChildren(List.of(arbol13));

        GeneralTree<Integer> arbol14 = new GeneralTree<>(0);

        arbol9.setChildren(List.of(arbol14));

        GeneralTree<Integer> arbol15 = new GeneralTree<>(1);

        arbol13.setChildren(List.of(arbol15));

        GeneralTree<Integer> arbol16 = new GeneralTree<>(0);
        GeneralTree<Integer> arbol17 = new GeneralTree<>(0);

        arbol14.setChildren(Arrays.asList(arbol16, arbol17));

        System.out.println(ParcialArboles.resolver(arbol1));
    }

}
