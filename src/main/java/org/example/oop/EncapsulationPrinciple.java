package org.example.oop;
/*
    --------------- Incapsulation ---------------
    Incapsularea = este un cancept prin care ascundem atributele clasei prin modificatorii de acces (private/protected) in
    scopul limitarii vizibilitatii publice si pentru a incuraja abstractizarea la nivel de metoda

    --------------- Object class ---------------
    Clasa de obiect este o clasa de tip wrapper (POJO - Plain Old Java Object) care defineste trasaturile si comportamentul
    unui obiect in mod generalist.

 */

class Employee {
    // Atributele = trasaturile generale ale obiectului de instanta al clasei
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private String team;

    // Constructorul = modul de definire al schitei  obiectului pe baza atributelor
    // By default toti constructorii sunt publici
    // constructorul neparametrizat - este mereu unul singur si are scopul de a defini o valoare incipienta a atributelor
    // de regula fiind limita inferioare a tipului de date al atributului (dar depinde de context)
    // acest tip de constructor instantiaza un obiect nedefinit
    public Employee() {
        this.id = -1;
        this.firstName = "placeholder first name";
        this.lastName = "placeholder last name";
        this.age = -1;
        this.team = "placeholder team";
    }
    // constructorii parametrizati = sunt in general o infinitate raportata la numarul de atribute
    // this = este un pointer care face referire la atributele clasei curente, motiv pentru care putem pastra o
    // corelatie vizuala intre denumirea atributelor si a argumentelor din constructor
    // alternativ, in cazul in care nu folosim "this", suntem obligati sa avem denumiri diferite intre cele 2 pentru a
    // nu crea confuzie compilatorului

    public Employee(long id, String firstName, String lastName, int employeeAge, String team) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = employeeAge;
        this.team = team;
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Functionalitatile = metode de utilizare prin intermediul instantei de obiect
    // getters/setters methods
    // getter = o metoda prin care interactionam cu valorile atributelor (public <attribute type> get<attibute name>() {return this aatribute}
    // setter = o metoda prin care setam valoarea atributelor printr-un argument dat (public void set <attribute name> get<attibute name>() {return this aatribute}
    // toate metodele getter si setter sunt publice
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }


    // overridden methods

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", team='" + team + '\'' +
                '}';
    }

    // custom methods
}

public class EncapsulationPrinciple {

    public static void main(String[] args) {
        Employee worker = new Employee();
        Employee worker2 = new Employee(1, "Maria", "Cabulea", 33, "P2P");
        Employee worker3 = new Employee("Alex", "Alexandru");
        System.out.println("Original 1st worker" + worker);
        System.out.println("Original 2nd worker: " + worker2);
        System.out.println("Original 3rd worker: " + worker3);

        worker.setAge(78);
        worker3.setTeam("Falcons");
        System.out.println("Medified 1st worker" + worker);
        System.out.println("Medified 3rd worker" + worker3);
    }
}
