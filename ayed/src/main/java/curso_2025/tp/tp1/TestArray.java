package curso_2025.tp.tp1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TestArray{
    public static void main(String[] args) {
        List<Integer> list = Arrays.stream(args).map(Integer::valueOf).toList();
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
