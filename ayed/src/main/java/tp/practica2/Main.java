package tp.practica2;

import org.ayed.ejercicio1y2.BinaryTree;
import org.ayed.ejercicio3.ContadorArbol;
import org.ayed.ejercicio4.RedBinariaLlena;
import org.ayed.ejercicio5.ProfundidadArbolBinario;
import org.ayed.ejercicio6.Transformacion;
import org.ayed.ejercicio7.ParcialArboles;

public class Main {
    public static void main(String[] args) {

        BinaryTree<Integer> ab = new BinaryTree<>(4);
        ab.addLeftChild(new BinaryTree<>(2));
        ab.addRightChild(new BinaryTree<>(6));
        ab.getLeftChild().addLeftChild(new BinaryTree<>(1));
        ab.getLeftChild().addRightChild(new BinaryTree<>(3));
        ab.getRightChild().addLeftChild(new BinaryTree<>(5));

        BinaryTree<Integer> ab2 = new BinaryTree<>(10);

        ab2.addLeftChild(new BinaryTree<>(2));
        ab2.getLeftChild().addLeftChild(new BinaryTree<>(5));
        ab2.getLeftChild().addRightChild(new BinaryTree<>(4));
        ab2.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<>(7));
        ab2.getLeftChild().getLeftChild().addRightChild(new BinaryTree<>(8));
        ab2.getLeftChild().getRightChild().addLeftChild(new BinaryTree<>(5));
        ab2.getLeftChild().getRightChild().addRightChild(new BinaryTree<>(6));

        ab2.addRightChild(new BinaryTree<>(3));
        ab2.getRightChild().addLeftChild(new BinaryTree<>(9));
        ab2.getRightChild().addRightChild(new BinaryTree<>(8));
        ab2.getRightChild().getLeftChild().addLeftChild(new BinaryTree<>(12));
        ab2.getRightChild().getLeftChild().addRightChild(new BinaryTree<>(8));
        ab2.getRightChild().getRightChild().addLeftChild(new BinaryTree<>(2));
        ab2.getRightChild().getRightChild().addRightChild(new BinaryTree<>(1));



//        ContadorArbol contadorArbol = new ContadorArbol(ab);
//        contadorArbol.numerosPares().forEach(numero -> System.out.print(numero+" "));
//
//        RedBinariaLlena redBinariaLlena = new RedBinariaLlena(ab2);
//        System.out.println(redBinariaLlena.retardoDeEnvio());
//
//        ProfundidadArbolBinario profundidadArbolBinario = new ProfundidadArbolBinario(ab2);
//        System.out.println(profundidadArbolBinario.sumaElementosProfundidad(2));

//        Transformacion transformacion = new Transformacion(ab);
//        BinaryTree<Integer> arbol = transformacion.suma();
//        arbol.imprimirArbol();

        ParcialArboles parcialArboles = new ParcialArboles();
        System.out.println(parcialArboles.isLeftTree(23));

    }
}