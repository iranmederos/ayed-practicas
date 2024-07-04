package parcial.lafuente;

import tp.practica2.ejercicio1y2.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class ParcialArboles {

    //debe devolver la cantidad de nodos
    public List<Integer> resolver(BinaryTree<Integer> tree, int min) {
        List<Integer> path = new ArrayList<>();
        List<Integer> auxPath = new ArrayList<>();
        recorrido(tree, path, auxPath, min);
        return auxPath;
    }

    public void recorrido(BinaryTree<Integer> tree, List<Integer> path, List<Integer> auxPath, int min) {
        path.add(tree.getData());
        if (!tree.isLeaf()) {
            if (tree.hasLeftChild()) {
                recorrido(tree.getLeftChild(), path, auxPath, min);
            }
            if (tree.hasRightChild()) {
                recorrido(tree.getRightChild(), path, auxPath, min);
            }
        }else if (tree.isLeaf()){
            int count = 0;
            for (Integer i : path) {
                count += i % 2 == 0 ? 1 : 0;
            }
            if (count >= min && auxPath.isEmpty()) {
                auxPath.addAll(path);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> ab = new BinaryTree<>(7);
        BinaryTree<Integer> ab2 = new BinaryTree<>(56);
        BinaryTree<Integer> ab3 = new BinaryTree<>(25);
        ab.addLeftChild(ab2);
        ab.addRightChild(ab3);

        BinaryTree<Integer> ab4 = new BinaryTree<>(38);
        BinaryTree<Integer> ab5 = new BinaryTree<>(31);
        ab2.addLeftChild(ab4);
        ab2.addRightChild(ab5);

        BinaryTree<Integer> ab6 = new BinaryTree<>(5);
        BinaryTree<Integer> ab7 = new BinaryTree<>(6);
        ab3.addLeftChild(ab6);
        ab3.addRightChild(ab7);

        BinaryTree<Integer> ab8 = new BinaryTree<>(87);
        BinaryTree<Integer> ab9 = new BinaryTree<>(77);
        ab4.addLeftChild(ab8);
        ab4.addRightChild(ab9);

        BinaryTree<Integer> ab10 = new BinaryTree<>(94);
        ab5.addRightChild(ab10);

        BinaryTree<Integer> ab11 = new BinaryTree<>(16);
        ab9.addRightChild(ab11);

        BinaryTree<Integer> ab12 = new BinaryTree<>(2);
        ab10.addRightChild(ab12);

        BinaryTree<Integer> ab13 = new BinaryTree<>(43);
        ab11.addRightChild(ab13);

        BinaryTree<Integer> ab14 = new BinaryTree<>(1);
        ab12.addLeftChild(ab14);

        BinaryTree<Integer> ab15 = new BinaryTree<>(9);
        BinaryTree<Integer> ab16 = new BinaryTree<>(10);
        ab13.addLeftChild(ab15);
        ab13.addRightChild(ab16);

        ParcialArboles p = new ParcialArboles();
        List<Integer> path = p.resolver(ab, 2);
        System.out.println(path);
    }
}
