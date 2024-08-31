package tp.practica2.ejercicio9;
import tp.practica2.ejercicio1y2.BinaryTree;

public class ParcialArboles {

    public BinaryTree<NodoInfo> sumAndDif(BinaryTree<Integer> arbol) { //se hizo una clase para poder rellenar el tipo de dato.
        BinaryTree<NodoInfo> arb = new BinaryTree<NodoInfo>(); //creo el arbol a retornar con la suma y diferencias de tipo (nodoinfo).
        if (!arb.isEmpty()) {
            this.sumAndDif(arbol, arb, 0, 0); //meotodo auxiliar con el arbol recibido, el arbol a retornar y la suma y diferencias en 0
        }
        return arb;
    }

    private void sumAndDif(BinaryTree<Integer> arbol, BinaryTree<NodoInfo> arb, int sum, int padre) { //suma y diferencia (padre) en 0
        int actual = arbol.getData(); //tomo el primer dato
        NodoInfo arbsumdif = new NodoInfo(actual + sum, actual - padre); //creo el nodo con las cuentas hechas.
        arb.setData(arbsumdif); //seteo el dato en el nuevo arbol.
        if (arbol.hasLeftChild()) {
            arb.addLeftChild(new BinaryTree<NodoInfo>());
            sumAndDif(arbol.getLeftChild(), arb.getLeftChild(), sum + actual, actual); //metodo recursivo para analizar hijo por hijo.
        }
        if (arbol.hasRightChild()) {
            arb.addRightChild(new BinaryTree<NodoInfo>());
            sumAndDif(arbol.getRightChild(), arb.getRightChild(), sum + actual, actual); //metodo recursivo para analizar hijo por hijo.
        }
    }
}