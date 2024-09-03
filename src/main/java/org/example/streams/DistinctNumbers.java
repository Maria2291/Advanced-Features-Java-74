package org.example.streams;
/*
    Fie o lista cu numere intregi duplicate. Creati o sublista doar cu numerele unice.
 */

import java.util.*;

public class DistinctNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,44,5,45,6,7,8,4,55,66,88,33,99,6,3,4,3,8);

        System.out.println("Distinct list with HashSet: " + extractDistinctNumbersUsingHashSet(numbers));
        System.out.println("Distinct list with TreeSet: " + extractDistinctNumbersUsingTreeSet(numbers));
        System.out.println("Distinct list iteratively: " + extractDistinctNumbersIteratively(numbers));
        System.out.println("Distinct list with streams: " + extractDistinctNumbersUsingStreams(numbers));


    }

    private static List<Integer> extractDistinctNumbersUsingStreams(List<Integer> numbers) {
        return numbers
                .stream()
                .distinct()
                .sorted()
                .toList();
    }

    private static List<Integer> extractDistinctNumbersIteratively(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();

        // Filtrare a valorilor duplicitare, astfel incat result sa contina doar aparentele unice
        for (Integer it: numbers) {
            if(!result.contains(it)) { // if value doesn't exist
                result.add(it);       // add to list
            }
        }

        // Sortare
        result.sort(Comparator.naturalOrder());

        return result;
    }

    private static List<Integer> extractDistinctNumbersUsingHashSet(List<Integer> numbers) {
        Set<Integer> result = new HashSet<>(numbers);
        return new ArrayList<>(result);

        // new ArrayList<>(newHashSet<>(numbers))
    }

    private static List<Integer> extractDistinctNumbersUsingTreeSet(List<Integer> numbers) {
        Set<Integer> result = new HashSet<>(numbers);
        return new ArrayList<>(result);
    }
}
