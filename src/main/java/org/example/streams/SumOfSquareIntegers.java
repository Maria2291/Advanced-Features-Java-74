package org.example.streams;

/*
    Fie o lista de valori. Calculati suma patratelor din lista.
    1,2,3,4,5 -> 2^2 + 4^2 = 2 + 16 = 20
 */


import java.util.Arrays;
import java.util.List;

public class SumOfSquareIntegers {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        System.out.println(" Suma patratelor iterativ: " + calculateSquareSumOfEvenNumbersIteratively(numbers));
        System.out.println(" \n Suma patratelor cu streams: " + calculateSquareSumOfEvenNumbersStreams(numbers));
        System.out.println(" \n Suma patratelor cu streams 2: " + calculateSquareSumOfEvenNumbersStreams(numbers));
    }

    private static Integer calculateSquareSumOfEvenNumbersIteratively(List<Integer> numbers) {

        Integer result = 0;

        for (Integer it: numbers) {
            if (it % 2 == 0) {
                result += it * it;    // Math.pow(it,2)
            }
        }
        return result;
    }

    private static Integer calculateSquareSumOfEvenNumbersStreams(List<Integer> numbers) {
        // PEEK = preia streamul pana in pinctul curent, si executa pentru fiecare element o functie,
        // dar nu modifica structura streamului in nici un fel
        return numbers
                // operatia de conversie
                .stream()
                // operatii interemediare
                .filter(it -> it % 2 == 0)  // cream o sublista doar cu valori pare
                .peek(it -> System.out.print(it + " "))
                .map(it -> it * it) // cream o sublista doar cu valori pare la patrat
                .peek(it -> System.out.print(it + " "))
                // operatia de colectare/redyctie
                .reduce(0, Integer::sum);
    }
    private static Integer calculateSquareSumOfEvenNumbersStreams2(List<Integer> numbers) {

        return numbers
                .stream()
                .filter(it -> it % 2 == 0)
                .map(it -> (int)Math.pow(it,2))
                .reduce(0, Integer::sum);
    }
}
