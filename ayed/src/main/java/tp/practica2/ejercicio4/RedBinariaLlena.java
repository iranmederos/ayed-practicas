package tp.practica2.ejercicio4;

import tp.practica2.ejercicio1y2.BinaryTree;

public class RedBinariaLlena {
    private final BinaryTree<Integer> integerBinaryTree;

    public RedBinariaLlena(BinaryTree<Integer> integerBinaryTree) {
        this.integerBinaryTree = integerBinaryTree;
    }

    public int retardoDeEnvio() {
        return retardoDeEnvioRecorrido(this.integerBinaryTree);
    }

    int retardoDeEnvioRecorrido(BinaryTree<Integer> binaryTree) {
        int cuentaIzquierdo = 0;
        int cuentaDerecho = 0;

        if (binaryTree.getData() > cuentaIzquierdo) {
            cuentaIzquierdo = binaryTree.getData();
            if(binaryTree.hasLeftChild())
                cuentaIzquierdo += retardoDeEnvioRecorrido(binaryTree.getLeftChild());
        }

        if (binaryTree.getData() > cuentaDerecho) {
            cuentaDerecho = binaryTree.getData();
            if (binaryTree.hasRightChild())
                cuentaDerecho += retardoDeEnvioRecorrido(binaryTree.getRightChild());
        }
        return Math.max(cuentaIzquierdo, cuentaDerecho);
    }
}

