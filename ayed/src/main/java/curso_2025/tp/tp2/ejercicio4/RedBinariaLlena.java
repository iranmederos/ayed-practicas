package tp2.ejercicio4;

import curso_2024.tp.practica2.ejercicio1y2.BinaryTree;

class RedBinariaLlena(){
    BinaryTree<T> tree;

    public RedBinariaLlena(BinaryTree<T> treeParam){
        this.tree = treeParam;
    }

    public int retardoReenvio(){
        return retardoReenvioWalk(this.tree);
    }

    private int retardoReenvioWalk(BinaryTree<T> ab){
        int left = 0;
        int right = 0;

        if (ab.hasLeftChild()){
            left += retardoReenvioWalk(ab.getLeftChild());
        }
        if (ab.hasRightChild()){
            right += retardoReenvioWalk(ab.getRightChild());
        }

        return Math.max(left,right) + ab.getData();
    }
}
