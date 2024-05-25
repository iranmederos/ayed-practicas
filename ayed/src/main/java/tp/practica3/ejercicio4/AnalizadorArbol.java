package tp.practica3.ejercicio4;

import tp.practica1.Queue;
import tp.practica3.ejercicio1y2y3y5.GeneralTree;

public class AnalizadorArbol {
    public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol) {
        if (!arbol.isEmpty()) {
            double promedio = 0;
            int suma = 0;
            int queueSize;
            GeneralTree<AreaEmpresa> currentNodo;
            Queue<GeneralTree<AreaEmpresa>> cola = new Queue<>();
            cola.enqueue(arbol);
            while (!cola.isEmpty()) {
                queueSize = cola.size();
                for (int i = 0; i < queueSize; ++i) {
                    currentNodo = cola.dequeue();
                    suma += currentNodo.getData().getRetardoMensaje();
                    if (currentNodo.hasChildren())
                        for (GeneralTree<AreaEmpresa> child : currentNodo.getChildren())
                            cola.enqueue(child);
                }
                suma = suma / queueSize;
                promedio = Math.max(promedio, suma);
                suma = 0;
            }
            return promedio;
        } else
            return 0;
    }
}
