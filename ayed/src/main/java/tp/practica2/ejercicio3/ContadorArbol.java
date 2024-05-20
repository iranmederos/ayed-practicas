package tp.practica2.ejercicio3;

import tp.practica2.ejercicio1y2.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class ContadorArbol {
    private final BinaryTree<Integer> integerBinaryTree;


    public ContadorArbol(BinaryTree<Integer> integerBinaryTree) {
        this.integerBinaryTree = integerBinaryTree;
    }

    public List<Integer> numerosPares(){
        List<Integer> numerosParesArray = new ArrayList<>();
        //numerosParesInOrden(numerosParesArray, this.integerBinaryTree);
        numerosParesPostOrden(numerosParesArray, this.integerBinaryTree);
        return numerosParesArray;
    }

    void numerosParesInOrden(List<Integer> numerosPares, BinaryTree<Integer> integerBinaryTree){
        if(integerBinaryTree.hasLeftChild())
            numerosParesInOrden(numerosPares, integerBinaryTree.getLeftChild());

        if(integerBinaryTree.getData() % 2 == 0){
            numerosPares.add(integerBinaryTree.getData());
        }

        if(integerBinaryTree.hasRightChild()){
            numerosParesInOrden(numerosPares, integerBinaryTree.getRightChild());
        }
    }

    void numerosParesPostOrden(List<Integer> numerosPares, BinaryTree<Integer> integerBinaryTree){
        if(integerBinaryTree.hasLeftChild())
            numerosParesInOrden(numerosPares, integerBinaryTree.getLeftChild());

        if(integerBinaryTree.hasRightChild()){
            numerosParesInOrden(numerosPares, integerBinaryTree.getRightChild());
        }

        if(integerBinaryTree.getData() % 2 == 0){
            numerosPares.add(integerBinaryTree.getData());
        }
    }


}
