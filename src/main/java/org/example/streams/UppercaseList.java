package org.example.streams;

/*
    Fie o lista de Stringuri cu litere mici. Creati o lista de dimensiune identica care sa contina toate stringurile
    cu litera mare.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UppercaseList {

    public static void main(String[] args) {
        List<String> fructe = Arrays.asList("cirese", "mere", "pere", "capsuni");

        System.out.println("Lista iterativa: " + convertToUppercaseIteratively (fructe));
        System.out.println("Lista cu streams: " + convertToUppsercaseStreams(fructe));
    }

    private static List<String> convertToUppsercaseStreams(List<String> fructe) {
        return fructe
                .stream()
                .map(it -> it.toUpperCase())
                .toList();
    }

    private static List<String> convertToUppercaseIteratively(List<String> fructe) {
        List<String> result = new ArrayList<>();

//        for (int i = 0; i < fructe.size(); i++) {
//            result.add(i, fructe.get(i).toUpperCase());
//        }

        // reminder: merge si cu enhanced for

        for(String it: fructe) {
            result.add(it.toUpperCase());
        }
        return result;
    }
}
