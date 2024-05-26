package tp.practica3.ejercicio7;

import tp.practica3.ejercicio1y2y3y5.GeneralTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Caminos {
    GeneralTree<Integer> arb = new GeneralTree<>(12);

    public List<Integer> caminoAHojaMasLejana() {
        if (this.arb.isEmpty())
            return null;
        List<Integer> caminoMax = new LinkedList<>();
        List<Integer> caminoActual = new LinkedList<>();
        caminoAHojaMasLejanaRecursive(caminoActual,caminoMax, this.arb);
        return caminoMax;
    }

    private void caminoAHojaMasLejanaRecursive(List<Integer> caminoActual,List<Integer> caminoMax, GeneralTree<Integer> arb){
        caminoActual.add(arb.getData());
        if (arb.hasChildren()) {
            for (GeneralTree<Integer> child : arb.getChildren()){
                caminoAHojaMasLejanaRecursive(caminoActual, caminoMax, child);
            }
        }
        if (caminoActual.size() > caminoMax.size()){
            caminoMax.removeAll(caminoMax);
            caminoMax.addAll(caminoActual);
        }
        caminoActual.removeLast();
    }


    public static void main(String[] args) {
         Caminos caminos = new Caminos();
         GeneralTree<Integer> arbol2 = new GeneralTree<>(17);
        GeneralTree<Integer> arbol3 = new GeneralTree<>(9);
        GeneralTree<Integer> arbol4 = new GeneralTree<>(15);

        caminos.arb.setChildren(Arrays.asList(arbol2, arbol3, arbol4));

        GeneralTree<Integer> arbol5 = new GeneralTree<>(10);
        GeneralTree<Integer> arbol6 = new GeneralTree<>(6);
        GeneralTree<Integer> arbol7 = new GeneralTree<>(1);
        GeneralTree<Integer> arbol8 = new GeneralTree<>(8);

        arbol2.setChildren(Arrays.asList(arbol5, arbol6, arbol8));

        arbol6.addChild(arbol7);

        System.out.println(caminos.caminoAHojaMasLejana());
    }
}

