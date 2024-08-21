package org.example.oop;

/*
Polimorfismul permite obiectelor din diferite clase sa fie tratate asemani clasei in care sunt suprascrise (Override) sau
supraincarcate (Overload)
adnotatii = Metadate

Override:
    - se asigura prin folosirea adnotarii Override
    - ne permite sa oferim o implementare personalizata unei metode preluata din clasa parinte
    - putem suprascrie in doua feluri:
        -- suprascriere din clasa parinte = metoda 'display' din Mammel este redefinita in Dog cu o alta implementare
        -- suprascriere din interfata = metoda 'display' din I1 primeste o implementare fiindca nu are niciuna
Overload <-> clasa:
    - se asigura la nivel de clasa!
    - se pastreaza integral denumirea metodei dar putem schimba semnatura complet (alt tip returnat si/sau alta implementare

 */
class Calculator {

    int add (int a, int b) {
        return a + b;
    }

    double add (double a, double b) {
        return a + b;
    }

    float add (float a, float b, float c) {
        return a + b + c;
    }
}

public class PolymorphismPrinciple {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.add(1, 2));
    }
}
