package org.example.streams;

/*
Exercise 10: Filtering, Sorting, and Reducing to Single Value
    Given a list of student objects,
    - filter out the students who passed the exam,
    - sort them based on their scores in descending order,
    - find the average score of the top 10 students.

    Student : name, score, passedExam (va fi calculat dpdv conditional pe baza score-ului)
    - name score vor fi valori pe care le trimitem prin constructor
    - passedExam:
 */

import lombok.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@NoArgsConstructor   // ne va creea contructorul neparametrizat (poate fi sters, fiindca vom utiliza constructorul partial)
@AllArgsConstructor  // ne va creea constructorul parametrizat cu toate atributele (poate fi sters, fiindca vom utiliza constructorul partial)
@Setter
@Getter
@ToString

class Student {
    private String name;
    // todo: in loc de un singur score, am putea avea o lista de scoruri pe baza careia sa se calculeze o medie per student
    // si la final o medie generala a listei de studenti
    private int score;
    private boolean passedExam;

    // alternativa lombok pt constructori partiali este @RequiredConstructor
    // doar ca nu e util in situatia actuala, pentru ca in constructor, unul dintre atribute il von determina pe baza altuia
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
        // todo: inlocuiti if-ul clasic cu un if tertiar (google it)
        // conditional checkup
        if(this.score >= 5) {
            this.passedExam = true;
        } else {
            this.passedExam = false;
        }
    }
}

public class AverageOfList {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 6));
        students.add(new Student("Ana", 5));
        students.add(new Student("Bob", 1));
        students.add(new Student("Delia", 10));
        students.add(new Student("Matei", 3));
        students.add(new Student("Adam", 7));
        students.add(new Student("Eve", 4));
        students.add(new Student("George", 5));
        students.add(new Student("Martinica", 8));
        students.add(new Student("Anisia", 9));
        students.add(new Student("Ioana", 2));

        // Algoritmul iterativ
            // filter by passedExam: vrem sa cream o sublista unde sa avem doar studentii care au promovat examentul
        List<Student> filteredStudents = new ArrayList<>();
        for(Student it: students) {
            if(it.isPassedExam()) // se face verificare de egalitate subinteleasa cu TRUE
                filteredStudents.add(it);
        }
            // sort descending order
        filteredStudents.sort(Comparator.comparingInt(Student::getScore).reversed());
        // Comparator.comparingInt(Student::getScore)) = sorteaza ascendent in functie de score-ul fiecarui student
        // Student::getScore = invocare a metodei de referinta = regula care seteaza modul de comparatie
        // .reversed() = inverseaza lista

            // average of scores
        double sum = 0;
        for (Student it: filteredStudents) {
            sum += it.getScore();
        }
        System.out.println("Media artmetica este: " + sum/filteredStudents.size());
        System.out.println("------------------------------------------------");

        // Algoritmul stream

        double resultStream = students
                /* conversie a structurii de date (list) la secventa de date (stream) */
                .stream()
                /* crearea unei subliste pe baza unei filtrari dupa isPassedExam */
                .filter(it -> it.isPassedExam())
                /* sortare inversa dupa getScore */
                .sorted(Comparator.comparingInt(Student::getScore).reversed())
                /* average: prima data cream sublista de elemente double */
                .mapToDouble(it -> it.getScore())
                /* average: la final facem media tuturor elementelor double din sublista
                * si stocam rezultatul in variabila resultStream */
                .average().getAsDouble();
        System.out.println("Media aritmetica cu stream este: " + resultStream);


    }
}
