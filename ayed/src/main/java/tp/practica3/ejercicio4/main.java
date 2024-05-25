package tp.practica3.ejercicio4;

import tp.practica3.ejercicio1y2y3y5.GeneralTree;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        AnalizadorArbol analizadorArbol = new AnalizadorArbol();
        AreaEmpresa area = new AreaEmpresa("M",14);
        GeneralTree<AreaEmpresa> tree = new GeneralTree<>(area);

        AreaEmpresa area2 = new AreaEmpresa("J",13);
        AreaEmpresa area3 = new AreaEmpresa("K",25);
        AreaEmpresa area4 = new AreaEmpresa("L",10);
        GeneralTree<AreaEmpresa> tree2 = new GeneralTree<>(area2);
        GeneralTree<AreaEmpresa> tree3 = new GeneralTree<>(area3);
        GeneralTree<AreaEmpresa> tree4 = new GeneralTree<>(area4);
        tree.setChildren(Arrays.asList(tree2,tree3,tree4));

        AreaEmpresa area5 = new AreaEmpresa("A",4);
        AreaEmpresa area6 = new AreaEmpresa("B",7);
        AreaEmpresa area7 = new AreaEmpresa("C",5);
        GeneralTree<AreaEmpresa> tree5 = new GeneralTree<>(area5);
        GeneralTree<AreaEmpresa> tree6 = new GeneralTree<>(area6);
        GeneralTree<AreaEmpresa> tree7 = new GeneralTree<>(area7);
        tree2.setChildren(Arrays.asList(tree5,tree6,tree7));

        AreaEmpresa area8 = new AreaEmpresa("D",6);
        AreaEmpresa area9 = new AreaEmpresa("E",10);
        AreaEmpresa area10 = new AreaEmpresa("F",18);
        GeneralTree<AreaEmpresa> tree8 = new GeneralTree<>(area8);
        GeneralTree<AreaEmpresa> tree9 = new GeneralTree<>(area9);
        GeneralTree<AreaEmpresa> tree10 = new GeneralTree<>(area10);
        tree3.setChildren(Arrays.asList(tree8,tree9,tree10));

        AreaEmpresa area11 = new AreaEmpresa("G",9);
        AreaEmpresa area12 = new AreaEmpresa("H",12);
        AreaEmpresa area13 = new AreaEmpresa("I",19);
        GeneralTree<AreaEmpresa> tree11 = new GeneralTree<>(area11);
        GeneralTree<AreaEmpresa> tree12 = new GeneralTree<>(area12);
        GeneralTree<AreaEmpresa> tree13 = new GeneralTree<>(area13);
        tree4.setChildren(Arrays.asList(tree11,tree12, tree13));

        System.out.println(analizadorArbol.devolverMaximoPromedio(tree));
        System.out.println(tree.esAncestro(area,area5));
    }
}
