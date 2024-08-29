package org.example.streams;

/*
    Fie o lista de numere intregi. Calculati suma tuturor valorilor.
 */

import java.util.Arrays;
import java.util.List;

public class SumIntegers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);

        System.out.println("Suma numerelor iterativ: " + calculateSumOfNumbersIteratively(numbers));
        System.out.println("Suma numerelor streams: " + calculateSumOfNumbersStreams(numbers));

    }

    private static Integer calculateSumOfNumbersStreams(List<Integer> numbers) {
        return numbers
                .stream()
                .reduce(0, Integer::sum);

        // Integer::sum -> (a,b) -> integer.sum(a,b)

    }

    private static Integer calculateSumOfNumbersIteratively(List<Integer> numbers) {
        Integer result = 0;

        for(Integer it: numbers) {
            result += it;   //  result = result + it
        }
        return result;
    }
}
