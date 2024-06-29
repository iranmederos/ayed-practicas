package parcial.arboles.segundafecha;

import tp.practica2.ejercicio1y2.BinaryTree;

public class ParcialArboles2 {
    BinaryTree<Integer> tree;

    ParcialArboles2(BinaryTree<Integer> tree) {
        this.tree = tree;
    }

    public BinaryTree<Integer> newTree() {
        BinaryTree<Integer> newTree = new BinaryTree<>(tree.getData());
        builder(tree, newTree);
        return newTree;
    }

    private void builder (BinaryTree<Integer> currentNode, BinaryTree<Integer> newTree) {
        if (currentNode.hasLeftChild()){
            int data = currentNode.getData() + currentNode.getLeftChild().getData();
            BinaryTree<Integer> left = new BinaryTree<>(data);
            newTree.addLeftChild(left);
            builder(currentNode.getLeftChild(), left);
        }
        if (currentNode.hasRightChild()){
            BinaryTree<Integer> right = new BinaryTree<>(currentNode.getRightChild().getData());
            newTree.addRightChild(right);
            builder(currentNode.getRightChild(), right);
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> ab = new BinaryTree<>(1);
        BinaryTree<Integer> ab2 = new BinaryTree<>(2);
        BinaryTree<Integer> ab3 = new BinaryTree<>(3);
        ab.addLeftChild(ab2);
        ab.addRightChild(ab3);
        BinaryTree<Integer> ab4 = new BinaryTree<>(4);
        ab2.addLeftChild(ab4);
        BinaryTree<Integer> ab5 = new BinaryTree<>(5);
        BinaryTree<Integer> ab6 = new BinaryTree<>(6);
        ab3.addLeftChild(ab5);
        ab3.addRightChild(ab6);
        BinaryTree<Integer> ab7 = new BinaryTree<>(7);
        ab5.addLeftChild(ab7);

        ParcialArboles2 pa2 = new ParcialArboles2(ab);
        BinaryTree<Integer> newTree = pa2.newTree();
        newTree.imprimirArbol();
    }
}
