import tp.practica3.ejercicio1y2y3y5.GeneralTree;

import java.util.Arrays;
import java.util.List;

public class ParcialArboles {

    public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
        int valorRaiz = arbol.getData();
        int minValor = Integer.MAX_VALUE;
        boolean cumple = false;
        boolean seguir = true;
        if (arbol.hasChildren()) {
            List<GeneralTree<Integer>> hijos = arbol.getChildren();
            for (GeneralTree<Integer> hijo : hijos) {
                minValor = hijo.getData() < minValor ? hijo.getData() : minValor;
            }
            if (minValor == valorRaiz) {
                int i = 0;
                while (seguir && i < hijos.size()) {
                    cumple = esDeSeleccion(hijos.get(i));
                    if (!cumple)
                        seguir = false;
                    i++;
                }
            }
        }
        if (!arbol.hasChildren()) cumple = true;

        return cumple;
    }
}

public static void main(String[] args) {
    GeneralTree<Integer> arbol1 = new GeneralTree<>(12);
    GeneralTree<Integer> arbol2 = new GeneralTree<>(12);
    GeneralTree<Integer> arbol3 = new GeneralTree<>(25);

    arbol1.setChildren(Arrays.asList(arbol2, arbol3));

    GeneralTree<Integer> arbol4 = new GeneralTree<>(35);
    GeneralTree<Integer> arbol5 = new GeneralTree<>(18);

    arbol2.setChildren(Arrays.asList(arbol4, arbol5));

    GeneralTree<Integer> arbol6 = new GeneralTree<>(25);

    arbol3.setChildren(List.of(arbol6));

    GeneralTree<Integer> arbol7 = new GeneralTree<>(35);

    arbol4.setChildren(List.of(arbol7));

    GeneralTree<Integer> arbol8 = new GeneralTree<>(14);
    GeneralTree<Integer> arbol9 = new GeneralTree<>(18);
    GeneralTree<Integer> arbol10 = new GeneralTree<>(33);

    arbol5.setChildren(Arrays.asList(arbol8, arbol9, arbol10));

    GeneralTree<Integer> arbol11 = new GeneralTree<>(35);

    arbol11.setChildren(List.of(arbol7));

    GeneralTree<Integer> arbol12 = new GeneralTree<>(35);
    GeneralTree<Integer> arbol13 = new GeneralTree<>(83);
    GeneralTree<Integer> arbol14 = new GeneralTree<>(90);
    GeneralTree<Integer> arbol15 = new GeneralTree<>(33);

    arbol10.setChildren(Arrays.asList(arbol12, arbol13, arbol14, arbol15));

    System.out.println(ParcialArboles.esDeSeleccion(arbol1));
}
