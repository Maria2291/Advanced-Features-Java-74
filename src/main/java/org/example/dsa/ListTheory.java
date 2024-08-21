package org.example.dsa;

/*
    List = este o interfata care defineste contractul comportamental al unei structuri de date ce are capacitatea de a stoca
    multimi de valori pe baza de index de pozitie.

    Sintaxa de definitie si instantiere: List <tipul de date> denumire_lista = new ArrayList<>()
    Pseudocod: Interfata obiect = new Constructor()

    List fiind o interfata, in mod obligatoriu este implementata de o serie de clase: ArrayList, LinkedList, etc.

    Indexarea valorilor/obiectelor stocare incepe de la 0 (zero), avand limita superioara n-1, unde n este numarul total de valori.

    CRUD = CREATE READ UPDATE DELETE
 */

import java.util.ArrayList;
import java.util.List;

public class ListTheory {

    public static void main(String[] args) {

        // Initializarea unei liste
        List<String> stringList = new ArrayList<>();

        System.out.println(stringList);

        /* ADD & ADD ALL*/
        stringList.add("apple");    // i = 0
        stringList.add("cherry");   // i = 1
        stringList.add("pear");     // i = 2
        System.out.println(stringList);

        stringList.add(1, "banana");
        System.out.println(stringList);

        stringList.addAll(new ArrayList<>(List.of("tomato", "watermelon")));
        System.out.println(stringList);

        stringList.addAll(4, new ArrayList<>(List.of("lettuce", "cucumber")));
        System.out.println(stringList);
        System.out.println("------------------------------------------------------------------------------");

        /* GET & iteration */
        System.out.println(stringList.get(5));
        System.out.println("Dimensiunea listei este: " + stringList.size());
        for (int i = 0; i < stringList.size(); i++) {
            System.out.println("Elementul: " + stringList.get(i) + ", pozitia: " + i);
        }
        System.out.println("------------------------------------------------------------------------------");

        /* SET */
        stringList.set(6, "strawberry");
        System.out.println(stringList);
        System.out.println("------------------------------------------------------------------------------");

        /* REMOVE */
        stringList.remove("peAr".toLowerCase());
        stringList.remove(5);

        System.out.println("Dimensiunea listei este: " + stringList.size());
        for (int i = 0; i < stringList.size(); i++) {
            System.out.println("Elementul: " + stringList.get(i) + ", pozitia: " + i);
        }
        System.out.println("------------------------------------------------------------------------------");

        stringList.removeAll(new ArrayList<>(List.of("banana", "cucumber", "water")));
        System.out.println(stringList.size() + "  " + stringList);
    }

}
