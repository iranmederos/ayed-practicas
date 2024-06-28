package tp.practica3.ejercicio11;

import tp.practica1.Queue;
import tp.practica3.ejercicio1y2y3y5.GeneralTree;

import java.util.Arrays;
import java.util.List;

public class ParcialArboles {
    GeneralTree<Integer> arbol;

    public static boolean resolver(GeneralTree<Integer> arbol){
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        GeneralTree<Integer> currentNodo;
        boolean cumple = true;
        int nivel = 1;

        cola.enqueue(arbol);
        cola.enqueue(null);

        if(arbol == null)
            cumple = false;
        while(!(cola.isEmpty()) && cumple){
            currentNodo = cola.dequeue();
            if(currentNodo != null && currentNodo.hasChildren()){
                for (GeneralTree<Integer> child : currentNodo.getChildren()){
                    cola.enqueue(child);
                }
            }
            if(currentNodo == null){
                nivel++;
                if (cola.size() != nivel)
                    cumple = false;
                if(!cola.isEmpty())
                    cola.enqueue(null);
            }
        }
        return cumple;
    }

    public static void main(String[] args) {
        GeneralTree<Integer> arbol1 = new GeneralTree<>(2);
        GeneralTree<Integer> arbol2 = new GeneralTree<>(1);
        GeneralTree<Integer> arbol3 = new GeneralTree<>(25);

        arbol1.setChildren(Arrays.asList(arbol2, arbol3));

        GeneralTree<Integer> arbol4 = new GeneralTree<>(5);
        GeneralTree<Integer> arbol5 = new GeneralTree<>(4);

        arbol2.setChildren(Arrays.asList(arbol4, arbol5));

        GeneralTree<Integer> arbol6 = new GeneralTree<>(13);

        arbol3.setChildren(List.of(arbol6));

        GeneralTree<Integer> arbol7 = new GeneralTree<>(18);

        arbol4.setChildren(List.of(arbol7));

        GeneralTree<Integer> arbol8 = new GeneralTree<>(7);
        GeneralTree<Integer> arbol9 = new GeneralTree<>(23);
        GeneralTree<Integer> arbol10 = new GeneralTree<>(33);

        arbol5.setChildren(Arrays.asList(arbol8, arbol9, arbol10));

        GeneralTree<Integer> arbol11 = new GeneralTree<>(35);

        arbol7.setChildren(List.of(arbol11));

        GeneralTree<Integer> arbol12 = new GeneralTree<>(35);
        GeneralTree<Integer> arbol13 = new GeneralTree<>(83);
        GeneralTree<Integer> arbol14 = new GeneralTree<>(90);
        GeneralTree<Integer> arbol15 = new GeneralTree<>(33);

        arbol10.setChildren(Arrays.asList(arbol12, arbol13, arbol14, arbol15));

        System.out.println(ParcialArboles.resolver(arbol1));
    }
}
