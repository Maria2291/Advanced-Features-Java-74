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

import java.util.Arrays;
import java.util.List;

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
    }
}
