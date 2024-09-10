package parcial.arboles.practicando;
import tp.practica3.ejercicio1y2y3y5.GeneralTree;
import java.util.*;

public class main {
        public static void main(String[] args) {
            // Crear el árbol general de enteros
            GeneralTree<Integer> root = new GeneralTree<>(10); // Nodo raíz con valor 10

            GeneralTree<Integer> child1 = new GeneralTree<>(-5);
            GeneralTree<Integer> child2 = new GeneralTree<>(15);

            GeneralTree<Integer> child1_1 = new GeneralTree<>(2);
            GeneralTree<Integer> child1_2 = new GeneralTree<>(-3);

            child1.addChild(child1_1);
            child1.addChild(child1_2);

            root.addChild(child1);
            root.addChild(child2);

            // Crear instancia de la clase ParcialArboles
            ParcialArboles parcialArboles = new ParcialArboles();

            // Llamar al método resolver y mostrar el resultado
            Integer resultado = parcialArboles.resolver(root);
            System.out.println("Resultado: " + resultado);
        }
        //Si esto funciona correctamente, debera devolver -8.
}