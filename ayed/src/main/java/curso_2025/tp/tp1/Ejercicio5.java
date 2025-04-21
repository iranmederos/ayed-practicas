package curso_2025.tp.tp1;

import java.util.stream.Gatherer;

public class Ejercicio5 {
    static int[] intArr = new int[] {9,2,5,1,4,6};

    public static Result operation(int[] integers){
        int minimo = Integer.MAX_VALUE;
        int maximo = Integer.MIN_VALUE;
        int promedio = 0;

        for (int n : integers){
            maximo = Math.max(n, maximo);
            minimo = Math.min(n, minimo);
            promedio += n;
        }
        return new Result(maximo,minimo,promedio/integers.length);
    }

    public static void main(String[] args) {
        System.out.println(operation(intArr));
    }
}
