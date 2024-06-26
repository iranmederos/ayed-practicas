package parcial.arboles;

import tp.practica1.Queue;
import tp.practica3.ejercicio1y2y3y5.GeneralTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParcialArbolesRefactor {
    private GeneralTree<Integer> ag;

    public ParcialArbolesRefactor(GeneralTree<Integer> ag) {
        this.ag = ag;
    }

    public List<Integer> nivel (int num) {
        List<GeneralTree<Integer>> nodes = new ArrayList<>();
        Queue<GeneralTree<Integer>> queue = new Queue<>();
        GeneralTree<Integer> current = this.ag;
        int cantChildren = current.getChildren().size();
        int cantNodesLevel = 1;
        if (cantChildren >= num) {
            nodes.add(current);
        } else {
            queue.enqueue(current);
            queue.enqueue(null);
            boolean fin = false;
            while (!queue.isEmpty() && !fin) {
                current = queue.dequeue();
                if (current == null)
                    cantNodesLevel = queue.size();
                if (current != null && current.hasChildren()) {
                    for (GeneralTree<Integer> child : current.getChildren())
                        queue.enqueue(child);
                    if (current.getChildren().size() >= num) {
                        nodes.add(current);
                        cantNodesLevel--;
                    }
                } else if (current == null) {
                    nodes = new ArrayList<>();
                    queue.enqueue(null);
                }
                if (cantNodesLevel == 0) {
                    fin = true;
                }
            }
        }
        return nodes.stream().map(GeneralTree::getData).toList();
    }
    public static void main(String[] args) {
        //nodo=10, hijos=8,-5
        GeneralTree<Integer> ag = new GeneralTree<>(10);
        GeneralTree<Integer> ag2 = new GeneralTree<>(8);
        GeneralTree<Integer> ag3 = new GeneralTree<>(-5);
        ag.setChildren(Arrays.asList(ag2, ag3));
        //nodo=8, hijos=5,22
        GeneralTree<Integer> ag4 = new GeneralTree<>(5);
        GeneralTree<Integer> ag5 = new GeneralTree<>(22);
        ag2.setChildren(Arrays.asList(ag4, ag5));
        //nodo=-5, hijos=19
        GeneralTree<Integer> ag6 = new GeneralTree<>(19);
        ag3.setChildren(List.of(ag6));
        //nodo=5, hijos=-6,2,8
        GeneralTree<Integer> ag7 = new GeneralTree<>(-6);
        GeneralTree<Integer> ag8 = new GeneralTree<>(2);
        GeneralTree<Integer> ag9 = new GeneralTree<>(8);
        ag4.setChildren(Arrays.asList(ag7, ag8, ag9));
        //nodo=22, hijos=28,55,18
        GeneralTree<Integer> ag10 = new GeneralTree<>(28);
        GeneralTree<Integer> ag11 = new GeneralTree<>(55);
        GeneralTree<Integer> ag12 = new GeneralTree<>(18);
        ag5.setChildren(Arrays.asList(ag10, ag11, ag12));
        //nodo=19, hijos=4,2,8
        GeneralTree<Integer> ag13 = new GeneralTree<>(4);
        GeneralTree<Integer> ag14 = new GeneralTree<>(2);
        GeneralTree<Integer> ag15 = new GeneralTree<>(8);
        ag6.setChildren(Arrays.asList(ag13, ag14, ag15));

        ParcialArbolesRefactor p = new ParcialArbolesRefactor(ag);
        List<Integer> nodes = p.nivel(0);
        System.out.println(nodes);
    }
}
