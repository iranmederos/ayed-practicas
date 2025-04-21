package curso_2025.tp.tp1;

public class Result {
    private int maximo = 0;
    private int promedio = 0;
    private int minimo = 0;

    public Result(){}

    public Result(int maximo, int minimo, int promedio){
        this.maximo = maximo;
        this.minimo = minimo;
        this.promedio = promedio;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public int getPromedio() {
        return promedio;
    }

    public void setPromedio(int promedio) {
        this.promedio = promedio;
    }

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    @Override
    public String toString(){
        return "maximo: "+getMaximo()+
                ", minimo: "+getMinimo()+
                ", promedio: "+getPromedio();
    }
}
