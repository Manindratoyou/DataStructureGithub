package com.manindra.practice_stream;

import java.util.Arrays;
import java.util.Collections;

public class ArrangeTheNumbers {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        Arrays.stream(arr).mapToObj(x -> x).sorted(Collections.reverseOrder()).
                forEach(System.out::print);
    }
}
