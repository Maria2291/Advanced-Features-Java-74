package org.example.oop;

/*
Interfata:
    - Este o clasa care are ca si scop stabilirea unei liste care cuprinde comportamentul unei tipologii de obiect, punand la
    dispozitie semnatura metodelor constituente.
    - Interfata poate instantia obiecte pe care le definim prin constructorul clasei de implementare -> List<String> shoppingList = new ArrayList() <>;
    - Nu poate stoca atribute/caracteristici comune.
    - Toate metodele sunt in mod standard publice.
    - Toate metodele sunt in mod standard abstracte fara implementare.
    - Nu avem constructori.

    Cand folosim interfata?
        - utilizam interfata in moemntul in care vrem sa generalizam o serie de metode pentru mai multe clase indiferent de localizarea
        lor in proiect.

    Clasa abstracta:
    - Keyword-ul abstract se utilizeaza in 2 scenarri -> la nivel de clasa si la nivel de metoda.
    - Este o clasa care are ca si scop definirea unui set comun de caracteristici sau comportamente comune pentru
    a fi mai departe mostenita -> clasa de configuratie (clasa parinte).
    - O clasa abstracta nu poate fi instantiata.
    - Metodele pot fi marcate cu orice madificator de acces dorit (public, private, protected, default).
    - Metodele pot fi fie abstracte cu sau fara implementare sau concreta.
    - Avem constructori.

    Cand folosim clasa abstracta?
        - utilizam clasa abstracta in momentul in care vrem sa generalizam o serie de atribute si metode comune pentru mai multe clase
        localizate in acelasi pachet parinte sau subpachet si avand acelasi context functional.
 */


// Aplicatie: Dat fiind 3 clase indentificand figuri geometrice, imi doresc sa creez o clasa abstracta si o interfata comuna
// care sa defineasca un nivel comun de configuratie penru toate figurile discutate (cerc, patrat, dreptunghi...)


/* Clasa parinte de configuratie */
abstract class Shape {

    protected double perimeter;
    protected double area;

    public abstract double calculateArea();

    public abstract double calculatePerimeter();

    public void display() {
        System.out.println("Perimeter: " + perimeter + " Area " + area);
    }
}

interface ShapeInterface {
    void draw();
}

class Circle extends Shape implements ShapeInterface{

    private double radius;

    Circle(double radius) {
        this.radius = radius;
        this.area = calculateArea();
        this.perimeter = calculatePerimeter();
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle!");

    }
}

class Square extends Shape implements ShapeInterface{

    private double value;
    Square (double value) {
        this.value = value;
        this.area = calculateArea();
        this.perimeter = calculatePerimeter();
    }

    @Override
    public double calculateArea() {
        return value * value;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * value;
    }

    @Override
    public void draw() {
        System.out.println("This is a square!");
    }
}

class Rectangular extends Shape implements ShapeInterface {

    private double length;
    private double width;

    Rectangular (double length, double width) {
        this.length = length;
        this.width = width;
        this.area = calculateArea();
        this.perimeter = calculatePerimeter();
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    @Override
    public void draw() {
        System.out.println("This is a rectangle!");
    }
}

class Triangle extends Shape implements ShapeInterface {

    private double latura;

    Triangle (double latura) {
        this.latura = latura;
        this.area = calculateArea();
        this.perimeter = calculatePerimeter();
    }
    @Override
    public double calculateArea() {
        return (Math.pow(latura, 2) * Math.sqrt(3)) / 4;
    }

    @Override
    public double calculatePerimeter() {
        return latura * 3;
    }

    @Override
    public void draw() {
        System.out.println("This is a triangle!");

    }
}
// todo: create a Triangle class

public class AbstractionPrinciple {

    public static void main(String[] args) {
        /** Exemplu 1: Abstractizare prin clase Wrapper */
        Integer nr1 = 98;
        Integer nr2 = 78;

        System.out.println(nr1.compareTo(nr2));


        // Exemplu 2:
        Circle circle = new Circle(4.5); // perimeter, area
        Square square = new Square(6);
        Rectangular rectangle = new Rectangular(7, 8);
        Triangle triangle = new Triangle(9);

        circle.display();
        square.display();
        rectangle.display();
        triangle.display();

    }
}
