package org.example.dsa;

/*
    Map = este o structura de date care permite stocarea elementelor de tipul pereche
    Perechile sunt de forma (cheie, valoare)
        Cheile reprezinta un subset al Mapei constituent de valori unice.
        Valorile reprezinta o sublista a Mapei costituenta din valori de orice fel (si unice, si duplicitatare)

    Implementarea finala a interfetei Map este HashMap fiind foarte similara ca si reguli de functionare cu HashSet.
 */

import java.util.HashMap;
import java.util.Map;

    public class MapTheory {

        public static void main(String[] args) {

            /* Initializarea si definirea unei mape */
            Map<String, Integer> myHashMap = new HashMap<>();

            /* PUT = simetricul din List/Set al lui ADD */
            // putem face atat adaugare de pereche, cat si actualizare
            myHashMap.put("John", 25);
            myHashMap.put("Alice", 12);
            myHashMap.put("Matthew", 87);
            System.out.println(myHashMap);
            System.out.println("------------------------");

            /* PUT ALL = putem face atat adaugare de perechi, cat si actualizare */
            myHashMap.putAll(new HashMap<>(
                    Map.of(
                            "Matei", 56,
                            "Bob", 99,
                            "John", 123
                    )
            ));
            System.out.println(myHashMap);
            System.out.println("------------------------");

            /* PUT IF ABSENT = putem face adaugare, doar daca cheia nu exista */
            // daca exista, nu facem actualizare
            myHashMap.putIfAbsent("Laur", 66);
            myHashMap.putIfAbsent("John", 66);
            System.out.println(myHashMap);
            System.out.println("------------------------");

            /* GET */
            System.out.println(myHashMap.get("Bob"));
            System.out.println("------------------------");

            /* VALUES/KEYSET */
            System.out.println(myHashMap.values()); // extrage sublista de valori
            System.out.println(myHashMap.keySet()); // extrage subsetul de chei
            System.out.println("------------------------");

            /* ITERATION METHODS */

            // Enhanced for - keySet
            System.out.println("Enhanced for keySet example: ");
            for (String it : myHashMap.keySet()) {
                System.out.println("(Key: " + it + ", Value: " + myHashMap.get(it) + ") ");
            }
            System.out.println("------------------------");

            // Enhanced for - values
            System.out.print("Enhanced for values example: ");
            for(Integer it: myHashMap.values()) {
                System.out.print(it + " ");
            }
            System.out.println("\n------------------------");

            // Pair iteration
            System.out.println("Pair iteration: ");
            for(Map.Entry<String, Integer> it: myHashMap.entrySet()) {
                System.out.println("(Key: " + it.getKey() + ", Value: " + it.getValue() + ") ");
            }

            // to do: iteration using iterator of Pair, remove, contains, clear, isEmpty
        }
    }


