package tp.practica2.ejercicio8;
import tp.practica2.ejercicio1y2.BinaryTree;


public class ParcialArboles {

    public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2){
        if (arbol1.isEmpty() || arbol2.isEmpty()) //verifico si uno esta vacio, si es asi...
            return arbol1.isEmpty() && arbol2.isEmpty(); //poseen la misma estructura, si no, no es prefijo.
        return esPrefijoRecursive(arbol1, arbol2); //entro aca cuando ambos arboles poseen al menos un dato.
    }

    private boolean esPrefijoRecursive(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2){
        if (arbol1.getData() != arbol1.getData())
            return false;

        boolean ok = true;
        if (arbol1.hasLeftChild()){
            if (arbol2.hasLeftChild()){
                ok = esPrefijoRecursive(arbol1.getLeftChild(), arbol2.getLeftChild());
            }else return false; //no hay misma estructura
        }

        if (arbol1.hasRightChild()) {
            if (arbol2.hasRightChild()) {
                ok = esPrefijoRecursive(arbol1.getRightChild(), arbol2.getRightChild());
            } else return false; //no hay misma estructura
        }

        return ok;
    }
}