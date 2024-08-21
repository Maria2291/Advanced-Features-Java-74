package org.example.oop;

/*
    Mostenirea ne permite sa preluam informatii generale dintr-o clasa parinte si sa le transmitem mai departe in clasele copil
    Scopul principal este acela de a crea un nivel de generalizare intre o serie de clase ce apartin aceluiasi context si de a le
    permite sa se diferentieze intre ele intr-un mod mult mai vizibil.

    Clasa parinte nu are vizibulitate in clasa copil.

    Multilevel inherintance = Mostenire multipla, intre o clasa copil si mai multi parinti. NU ESTE POSIBIL deoarece o clasa copil corespunde unui singur parinte.

    Ce alternative avem?
    1. Mostenire multipla din copil in copil, adica fiecare copil la lrandul lui devinde parinte pentru alte clase
        ex: Mammel -> Dog -> BabyDog -> etc
    2. Mostenire multipla la nivel de interfete
    Interfata = este un tip de clase care defineste de regula contractul comportamental al unei tipologii de obiect

    Cand utilizam mostenirea prin clase?
        - de regula atunci cand dispunem de minim doua clase copil care au in comun un set de atribute
    Cand utilizam imterfete?
        - de regula atunci cand dispunem de minim doua clase care au in comun acelasi set de metode, insa cu implementari diferite



 */
/* Parent class = Base class */
class Mammel {

    int age;
    String furColor;
    String species;

    Mammel(int age, String furColor, String species) {
       this.age = age;
       this.furColor = furColor;
       this.species = species;
    }
    Mammel(int age, String furColor) {
        this.age = age;
        this.furColor = furColor;
    }

    void display() {
        System.out.println("Parent Mammel class: " + this.species + " " + this.furColor + " " + this.age + " ");
    }

    void sound() {
        System.out.println("Mammel makes sound!");
    }
}

/* Child class = Derived class */
class Dog extends Mammel {

    String favouriteToy;

    Dog(int age, String furColor, String favouriteToy) {
        super(age, furColor); // Apeleaza constructorul din clasa parinte pentru atributele generice prin sintaxa lui de constructor
        this.favouriteToy = favouriteToy;
    }

    @Override
    void display() {
        super.display(); // Apelam metodele sau atributele din clasa parinte prin sintaxa lui super de obiect de tipul Mammel
        System.out.println("Child Dog class: " + favouriteToy);
        System.out.println(super.furColor);
    }

    @Override
    void sound() {
        super.sound();
        System.out.println("Dog barks!");
    }
}

class BabyDog extends Dog {
    BabyDog(int age, String furColor, String favouriteToy) {
        super(age, furColor, favouriteToy);
    }

}

class cat extends Mammel {

    cat(int age, String furColor) {
        super(age, furColor);
    }
}

interface I1 {
    void display();
    // putem avea oricate metode vrem
    // mecanismul de definire al unui contract comportamental este strict legat de contextul aplicatiei
}

interface I2 {
    void sound();
}

class I implements I1, I2 {

    @Override
    public void display() {
        System.out.println("Hello world!");
    }

    @Override
    public void sound() {
        System.out.println("Ham ham");

    }
}

class Other implements I2 {

    @Override
    public void sound() {
        System.out.println("Meow meow");
    }
}

public class InheritancePrinciple {

    public static void main(String[] args) {
    Mammel mammel = new Mammel(5, "Rosu", "Raton");
    Mammel dog1 =  new Dog(4, "alb", "os");
    Dog dog2 = new Dog(13, "maro", "minge");
//    Dog dog3 = new Mammel(1, "mov", "papusa"); //INCOMPATIBLE TYPE pentru ca atributul clasei copil ramane pe dinafara!

    mammel.display();
    mammel.sound();
    System.out.println("--------------------");

    dog1.display();
    dog1.sound();
    System.out.println("--------------------");

    dog2.display();
    dog2.sound();

    }
}
