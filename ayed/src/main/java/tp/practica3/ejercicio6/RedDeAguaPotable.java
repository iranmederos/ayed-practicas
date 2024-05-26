package tp.practica3.ejercicio6;

import tp.practica3.ejercicio1y2y3y5.GeneralTree;

import java.util.Arrays;
import java.util.List;

public class RedDeAguaPotable {
    public GeneralTree<Character> tree = new GeneralTree<>('A');

    public double minimoCaudal(double caudal) {
        if (this.tree.isLeaf())
            return caudal;
        if (tree.isEmpty())
            return 0.0;
        return minimoCaudalRecursive(this.tree, caudal);
    }

    public double minimoCaudalRecursive(GeneralTree<Character> tree, double caudal) {
        if (tree.hasChildren()) {
            int cantChildren = tree.getChildren().size();
            double childrenCaudal = caudal / cantChildren;
            double minCaudal = childrenCaudal;
            List<GeneralTree<Character>> children = tree.getChildren();
            for (GeneralTree<Character> child : children) {
                minCaudal = Math.min(minCaudal, minimoCaudalRecursive(child, childrenCaudal));
            }
            return minCaudal;
        }
        return caudal;
    }

    public static void main(String[] args) {
        GeneralTree<Character> tree2 = new GeneralTree<>('B');
        GeneralTree<Character> tree3 = new GeneralTree<>('C');
        GeneralTree<Character> tree4 = new GeneralTree<>('D');
        GeneralTree<Character> tree5 = new GeneralTree<>('E');
        GeneralTree<Character> tree6 = new GeneralTree<>('F');
        GeneralTree<Character> tree7 = new GeneralTree<>('G');

        RedDeAguaPotable redDeAguaPotable = new RedDeAguaPotable();
        tree3.setChildren(Arrays.asList(tree5, tree6));
        tree6.setChildren(List.of(tree7));
        redDeAguaPotable.tree.setChildren(Arrays.asList(tree2, tree3, tree4));

        System.out.println(redDeAguaPotable.minimoCaudal(500));
    }
}
