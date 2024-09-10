/*Enunciado:
    Implemente en la clase ParcialArboles un metodo que reciba un arbol general de enteros y calcule la suma de todos los nodos.
    Luego, si la suma es par, el metodo debera devolver la suma de los numeros positivos. En caso contrario, debera devolver
    la suma de los numeros negativos. Realizar un recorrido PostOrden.

    El metodo debe tener la siguiente firma:
        resolver(ArbolGeneral<Integer arbol>):Integer
*/
package parcial.arboles.practicando;
import tp.practica3.ejercicio1y2y3y5.GeneralTree;
import java.util.*;

public class ParcialArboles {

    public Integer resolver(GeneralTree<Integer> arb){
        if (!arb.isEmpty()) {
            int[] sumas = new int[3]; //sumaTotal, sumaPositivos, sumaNegativos
            recorrerYSumarPost(arb, sumas); //realiza recorrido y sumas de una sola pasada

            if (sumas[0] % 2 == 0) { //verifica si suma total es par o impar
                return sumas[1]; //si es par devuelve la suma de los positivos
            } else {
                return sumas[2]; //si es impar devuelve la suma de los negativos
            }
        }
        return 0; //retorna 0 si el arbol es vacio
    }

    private void recorrerYSumarPost(GeneralTree<Integer>arb, int[] sumas) {
        //1. Recorre hijos del nodo actual
        for (GeneralTree<Integer> child : arb.getChildren()) {
            recorrerYSumarPost(child, sumas); //llamada recursiva a cada hijo primero (PostOrder)
        }
        //2. Procesar valor del nodo actual (Despues de sus hijos)
        int act = arb.getData();

        //Acumular SumaTotal
        sumas[0] += act;

        //Acumular en SumaPositivos si es mayor a 0
        if (act > 0){
            sumas[1] += act;
        }
        //Acumular en SumaNegativos si es menor a 0
        if (act < 0){
            sumas[2]+= act;
        }
    }
}