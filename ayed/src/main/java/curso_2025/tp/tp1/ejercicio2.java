package curso_2025.tp.tp1;

public class ejercicio2 {

    public static int[] numToArray(int n){
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = (i+1)*n;
        }
        return arr;
    }

    public static void main(String[] args) {
        for (int n : numToArray(5))
            System.out.print(n+" ");
    }
}
