package parcial.arboles;

import tp.practica3.ejercicio1y2y3y5.GeneralTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import tp.practica1.Queue;

public class ParcialArboles {
    private GeneralTree<Integer> ag;

    public ParcialArboles() {}

    public ParcialArboles(GeneralTree<Integer> ag) {
        this.ag = ag;
    }

    public List<Integer> nivel (int num){
        List<Integer> nodes = new ArrayList<>();
        Queue<GeneralTree<Integer>> queue = new Queue<>();
        GeneralTree<Integer> current = this.ag;
        int cantChildren = current.getChildren().size();

        if(cantChildren == num){
            nodes.add(current.getData());
        }else {
            List<GeneralTree<Integer>> aux = new ArrayList<>();
            Queue<GeneralTree<Integer>> auxQueue = new Queue<>();
            GeneralTree<Integer> auxNode;
            queue.enqueue(current);
            queue.enqueue(null);
            int cantNodesNextLevel = current.getChildren().size();
            boolean fin = false;
            while(!queue.isEmpty() && !fin){
                current = queue.dequeue();
                if(current != null && current.hasChildren()){
                    List<GeneralTree<Integer>> children = current.getChildren();
                    for(GeneralTree<Integer> child : children){
                        queue.enqueue(child);
                        auxQueue.enqueue(child);
                        if(child.getChildren().size() == num){
                            aux.add(child);
                        }
                    }
                    if(aux.size() == cantNodesNextLevel){
                        for(GeneralTree<Integer> child : aux){
                            nodes.add(child.getData());
                        }
                    }
                }else if(current == null) {
                    cantNodesNextLevel=0;
                    aux = new ArrayList<>();
                    queue.enqueue(current);
                    while(!auxQueue.isEmpty()){
                        auxNode= auxQueue.dequeue();
                        cantNodesNextLevel += auxNode.getChildren().size();
                    }
                }
                if (cantNodesNextLevel == 0)
                        fin= true;
            }
        }
        return nodes;
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

        ParcialArboles p = new ParcialArboles(ag);
        List<Integer> nodes = p.nivel(3);
        System.out.println(nodes);
    }
}
