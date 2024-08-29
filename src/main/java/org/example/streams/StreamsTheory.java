package org.example.streams;

/*
    !!! STREAMURILE SE UTILIZEAZA DOAR IN CONTEXTUL STRUCTURILOR DE DATE !!!

    Streams = este un contract de metode (API = Application Programming Interface) care pune in valoare o maniera de
    programare axata pe utilizarea operatiilor functionale.

    O operatie functionala se refera la prelucrarea unui set de date intr-o forma generica, astfel incat sa putem
    extrage diverse metrici indiferent de structura de date utilizata.

    Stremurile au scopul de a generaliza operatiile clasice iterative de:
        - utilizare a instructiunilor conditionale (if, switch)
        - utilizare a instructiunilor repetitive (for, while, do-while)
        - utilizare a instructiunilor de conversie

    Avantaje:
        - devlarative: standardizare a codului dupa o intelegere comuna a membrilor echipei
        - lazy evaluation: operatiile pe streamer sunt invocate la momentul executiei instructiunii, fara a mai avea
        nevoie de faze intermediare de prelucrare/stocare
        - pipeline: (builder type class) executia unei operatiuni folosind streamuri va avea invocari repetate a obiectului
        curent pentru toate etapele intermediare

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsTheory {

    public static void main(String[] args) {

        // 1st example sorting
        List<String> names = Arrays.asList("Alice", "Bob", "Ana", "Beatrice");
        List<String> orderedNames = names
                .stream()
                .sorted()
                .toList();
        System.out.println("Lista dezordonata: " + names);
        System.out.println("Lista ordonata: " + orderedNames);
        System.out.println("------------------------------------------------------------");

        List <String> names2 = new ArrayList<>();
        names2.add("Alice");
        names2.add("Bob");
        names2.add("Anna");
        names2.add("Beatrice");
        names2.add("Joe");

        /* Pas 1: Operatia de conversie a sructurii de date la tipul de date generic pentru secvente -> Stream */
        Stream<String> streamOfNames = names2.stream();

        /* Pas 2: Operatiile intermediare (filter, map, distinct, sorted, etc.) */
        Stream<String> filteredStreamOfNamesWith3Letters = streamOfNames.filter(it -> it.length() == 3);
        // putem avea oricate operatii intermediare vrem, toate avand ca tip de date Stream pentru ca toate prelucrarile
        // se fac sub aceeasi tipologie

        /* Pas 3: Operatia terminala -> facem conversia de la Stream la tipul de date al rezultatului pe care ni-l dorim */
        List<String> listOfNamesWith3Letters = filteredStreamOfNamesWith3Letters.toList();
        System.out.println("List with streams: " + listOfNamesWith3Letters);

        /* Echivalentul algoritmului in mod iterativ */
            // Alice - 0, Bob - 1, Anna - 2, Beatrice - 3, Joe - 4
            // declaram o sublista ca si rezultat final al filtrarii
            // parcurgem lista cu un FOR(0, n-1)
            // vom avea o intructiune conditionala IF(it.length() == 3)
            // daca e adevarat, stocam elementele in sublista
            // afisam lista
        List<String> result = new ArrayList<>();
        for (String it: names2) {
            if(it.length() == 3){
                result.add(it);
            }
        }
        System.out.println("List iterativ: " + result);

        /* Echivalentul algoritnmului in mod stream pipeline */
        List<String> finalListOfNames = names2
                .stream()
                .filter(it -> it.length() == 3)
                .toList();
        System.out.println("List with streams pipeline: " + finalListOfNames);
    }
}
