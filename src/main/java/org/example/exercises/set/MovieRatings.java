package org.example.exercises.set;

import java.time.LocalDate;
import java.util.*;

/*
    Movie Ratings:
    Implement a movie rating system using both a HashSet and a TreeSet where movies are stored and sorted based on their
    ratings.
 */

class Movie {
    private String title;
    private Double rating;
    private LocalDate releaseDate;

    public Movie(String title, Double rating, LocalDate releaseDate) {
        this.title = title;
        this.rating = rating;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                ", releaseDate=" + releaseDate +
                '}';
    }
}

public class MovieRatings {

    public static void main(String[] args) {
        Set<Movie> movieUnorderedSet = new HashSet<>();

        movieUnorderedSet.add(new Movie("Inception", 8.8, LocalDate.of(2004,12,4)));
        movieUnorderedSet.add(new Movie("It ends with us", 9.0, LocalDate.of(2024,8,1)));
        movieUnorderedSet.add(new Movie("Titanic", 9.0, LocalDate.of(1999,10,5)));
        movieUnorderedSet.add(new Movie("Eat,pray,love", 8.0, LocalDate.of(2020,7,5)));

        System.out.println("Setul contine:\n" + movieUnorderedSet);

        // ArrayList si sort
        List<Movie> movieSortedList = new ArrayList<>(movieUnorderedSet);
        System.out.println("Lista neordonata contine:\n");
        displayList(movieSortedList);

        /*
        * Comparator are structura de Builder class.
        *
        * Ce este un Builder?
        * - este o clasa de obiect unde semnatura metodelor cu tip de returnare contine clasa curenta, astfel incat sa
        * putem avea chained invocations (apelari inlantuite).
        *
        * Comparator
        * .comparing (...)
        * .thenCompare (...)
        * .etc;
         */

        movieSortedList.sort(Comparator
                .comparing(Movie::getRating)
                .thenComparing(Movie::getReleaseDate)
                .reversed()
        );
        System.out.println("Lista sortata contine:\n ");
        displayList(movieSortedList);
        /*
        * Comparator.comparing(Movie::getRating)
        * - se uita intern in clasa Movie
        * - si compara doua elemente random din lista noastra pe beza metodei de referinta
        * - metoda de referinta este de regula un getter (fiindca datele noastre sunt private)
        * - referentierea directa prin numele clasei::metoda (Movie::getRating), functioneaza doar pentru
        * metodele NEPARAMETRIZATE
         * */

        // Collections si sort

    }
    public static void displayList(List<Movie> list) {
        for(Movie it: list) {
            System.out.println(it.getTitle() + " " + it.getRating() + " " + it.getReleaseDate());
        }
        System.out.println();
    }
}
