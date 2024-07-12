package tp.practica5.ejercicio3;

import tp.practica5.ejercicio1.Edge;
import tp.practica5.ejercicio1.Graph;
import tp.practica5.ejercicio1.Vertex;
import tp.practica5.ejercicio1.adjList.AdjListGraph;
import tp.practica5.ejercicio2.Recorridos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mapa {
    private final Graph<String> mapaCiudades;

    public Mapa(Graph<String> mapa) {
        this.mapaCiudades = mapa;
    }

    public List<String> devolverCamino(String ciudad1, String ciudad2) {
        Vertex<String> origen = this.mapaCiudades.search(ciudad1);
        Vertex<String> destino = this.mapaCiudades.search(ciudad2);
        boolean[] visited = new boolean[this.mapaCiudades.getSize()];
        List<String> res = new ArrayList<>();
        dfsCiudades(origen, destino, visited, res);
        return res.contains(ciudad2) ? res : new ArrayList<>();
    }

    private void dfsCiudades(Vertex<String> origen, Vertex<String> destino, boolean[] visited, List<String> res) {
        visited[origen.getPosition()] = true;
        List<Edge<String>> neighbors = this.mapaCiudades.getEdges(origen);
        res.add(origen.getData());
        for (Edge<String> neighbor : neighbors) {
            if (!visited[neighbor.getTarget().getPosition()]) {
                if (!visited[destino.getPosition()])
                    dfsCiudades(neighbor.getTarget(), destino, visited, res);
            }
        }
    }

    public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades){
        Vertex<String> origen = this.mapaCiudades.search(ciudad1);
        Vertex<String> destino = this.mapaCiudades.search(ciudad2);
        boolean[] visited = new boolean[this.mapaCiudades.getSize()];
        List<String> res = new ArrayList<>();
        dfsCiudadesExceptuando(origen, destino, visited, res, ciudades);
        return res.contains(ciudad2) ? res : new ArrayList<>();
    }

    private void dfsCiudadesExceptuando(Vertex<String> origen, Vertex<String> destino, boolean[] visited, List<String> res, List<String> ciudades) {
        visited[origen.getPosition()] = true;
        List<Edge<String>> neighbors = this.mapaCiudades.getEdges(origen);
        res.add(origen.getData());
        for (Edge<String> neighbor : neighbors) {
            if (!visited[neighbor.getTarget().getPosition()]) {
                if (!visited[destino.getPosition()] && !ciudades.contains(neighbor.getTarget().getData()))
                    dfsCiudadesExceptuando(neighbor.getTarget(), destino, visited, res, ciudades);
            }
        }
    }

    public static void main(String[] args) {
        Graph<String> ciudades = new AdjListGraph<String>();
        Mapa rec = new Mapa(ciudades);
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

        for (String ciudad : rec.devolverCaminoExceptuando("Buenos Aires", "Paris", Arrays.asList("Santiago", "Madrid"))) {
            System.out.println(ciudad);
        }
    }
}

