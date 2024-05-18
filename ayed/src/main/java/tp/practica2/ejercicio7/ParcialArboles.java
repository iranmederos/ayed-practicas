package tp.practica2.ejercicio7;

import org.ayed.ejercicio1y2.BinaryTree;

public class ParcialArboles {
    private BinaryTree<Integer> tree;

    public ParcialArboles() {
        tree = new BinaryTree<>(2);
        tree.addLeftChild(new BinaryTree<>(7));
        tree.getLeftChild().addLeftChild(new BinaryTree<>(23));
        tree.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<>(-3));
        tree.getLeftChild().addRightChild(new BinaryTree<>(6));
        tree.getLeftChild().getRightChild().addLeftChild(new BinaryTree<>(55));
        tree.getLeftChild().getRightChild().addRightChild(new BinaryTree<>(11));

        tree.addRightChild(new BinaryTree<>(-5));
        tree.getRightChild().addLeftChild(new BinaryTree<>(19));
        tree.getRightChild().getLeftChild().addRightChild(new BinaryTree<>(4));
        tree.getRightChild().getLeftChild().getRightChild().addLeftChild(new BinaryTree<>(18));
    }

    public boolean isLeftTree(int num) {
        finder(this.tree, num);
        return isLeftTreeValidate(this.tree);
    }

    void finder(BinaryTree<Integer> tree, int num){
        if (tree.getData() == num)
            this.tree = tree;
        if(tree.hasLeftChild())
            finder(tree.getLeftChild(),num);
        if(tree.hasRightChild())
            finder(tree.getRightChild(), num);
    }

    int counterTree(BinaryTree<Integer> tree) {
        int counter = 0;
        if (tree.hasLeftChild())
            if (tree.hasLeftChild() && !tree.hasRightChild())
                counter += counterTree(tree.getLeftChild()) + 1;
        if (tree.hasRightChild()) {
            if (tree.hasRightChild() && !tree.hasLeftChild())
                counter += counterTree(tree.getRightChild()) + 1;
        }
        return counter;
    }

    boolean isLeftTreeValidate(BinaryTree<Integer> tree) {
        int rigthCount = -1, leftCount = -1;
        if (tree.hasLeftChild())
            leftCount = counterTree(tree.getLeftChild());
        if (tree.hasRightChild())
            rigthCount = counterTree(tree.getRightChild());
        return leftCount > rigthCount;
    }
}
