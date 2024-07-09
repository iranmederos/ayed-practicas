package tp.practica5.ejercicio2;

import tp.practica5.ejercicio1.Edge;
import tp.practica5.ejercicio1.Graph;
import tp.practica5.ejercicio1.Vertex;
import tp.practica5.ejercicio1.adjList.AdjListGraph;

import java.util.ArrayList;
import java.util.List;

public class Recorridos<T> {

    public List<T> dfs(Graph<T> grafo){
        Vertex<T> origen = grafo.getVertex(0);
        boolean[] visited = new boolean[grafo.getVertices().size()];
        List<T> res = new ArrayList<>();
        dfsRecorrido(origen, visited, res, grafo);
        return res;
    }

    private void dfsRecorrido(Vertex<T> origen, boolean[] visited, List<T> res, Graph<T> grafo){
        //marcamos como visitado el origen
        visited[origen.getPosition()] = true;
        List<Edge<T>> neighbors =  grafo.getEdges(origen);
        res.add(origen.getData());
        for (Edge<T> neighbor : neighbors){
            if (!visited[neighbor.getTarget().getPosition()]){
                dfsRecorrido(neighbor.getTarget(), visited, res, grafo);
            }
        }
    }


    public static void main(String[] args) {
        Graph<String> ciudades = new AdjListGraph<String>();
        Recorridos<String> rec = new Recorridos<String>();
        Vertex<String> v1 = ciudades.createVertex("Buenos Aires");
        Vertex<String> v2 = ciudades.createVertex("Santiago");
        Vertex<String> v3 = ciudades.createVertex("Asunción");
        Vertex<String> v4 = ciudades.createVertex("Tokio");
        Vertex<String> v5 = ciudades.createVertex("Roma");
        Vertex<String> v6 = ciudades.createVertex("Paris");
        Vertex<String> v7 = ciudades.createVertex("Madrid");
        Vertex<String> v8 = ciudades.createVertex("Caracas");
        ciudades.connect(v1, v2);
        ciudades.connect(v1, v3);
        ciudades.connect(v2, v5);
        ciudades.connect(v3, v7);
        ciudades.connect(v3, v8);
        ciudades.connect(v8, v7);
        ciudades.connect(v8, v4);
        ciudades.connect(v5, v4);
        ciudades.connect(v7, v4);
        ciudades.connect(v6, v5);
        ciudades.connect(v6, v7);
        ciudades.connect(v6, v4);
        ciudades.connect(v4, v1);
        ciudades.connect(v1, v6);

        for (String ciudad : rec.dfs(ciudades)){
            System.out.println(ciudad);
        }
    }
}
