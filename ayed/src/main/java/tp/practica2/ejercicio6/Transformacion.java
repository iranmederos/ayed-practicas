package tp.practica2.ejercicio6;

import tp.practica2.ejercicio1y2.BinaryTree;


public class Transformacion {
//    Cree una clase Java llamada Transformacion que tenga como variable de instancia un árbol
//    binario de números enteros y un método de instancia suma (): BinaryTree<Integer> el cuál
//    devuelve el árbol en el que se reemplazó el valor de cada nodo por la suma de todos los
//    elementos presentes en su subárbol izquierdo y derecho. Asuma que los valores de los subárboles
//    vacíos son ceros.

    BinaryTree<Integer> binaryTree;

    public Transformacion(BinaryTree<Integer> binaryTree) {
        this.binaryTree = binaryTree;
    }

    public BinaryTree<Integer> suma() {
        transformar(this.binaryTree);
        return this.binaryTree;
    }

    public int transformar(BinaryTree<Integer> binaryTree){
        int suma = 0;
        int dato = binaryTree.getData();

        if(!binaryTree.isLeaf()){
            if(binaryTree.hasLeftChild())
                suma += transformar(binaryTree.getLeftChild());
            if (binaryTree.hasRightChild())
                suma += transformar(binaryTree.getRightChild());
            binaryTree.setData(suma);
        }

        if (binaryTree.isLeaf())
            binaryTree.setData(0);

        return suma + dato;
    }
}
