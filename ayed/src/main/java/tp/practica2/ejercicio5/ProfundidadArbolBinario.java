package tp.practica2.ejercicio5;

import tp.practica2.ejercicio1y2.BinaryTree;


public class ProfundidadArbolBinario {
    public BinaryTree<Integer> arb;


    public ProfundidadArbolBinario(BinaryTree<Integer> arb) {
        this.arb = arb;
    }


    //pasarle la profundidad deseada.
    public int sumaElementosProfundidad(int p) {
        return (!arb.isEmpty()) ? contarSumaElementosProfundidad(p, 0, arb) : 0;
    }

    private int contarSumaElementosProfundidad(int p, int c, BinaryTree<Integer> arb) {
        int suma = 0;
        if (c <= p) {
            if (arb.hasLeftChild()) {
                suma = arb.getData() + contarSumaElementosProfundidad(p, c + 1, arb.getLeftChild());

            }
            if (arb.hasRightChild()) {
                suma = arb.getData() + contarSumaElementosProfundidad(p, c + 1, arb.getRightChild());
            }
        }
        return suma;
    }
}
