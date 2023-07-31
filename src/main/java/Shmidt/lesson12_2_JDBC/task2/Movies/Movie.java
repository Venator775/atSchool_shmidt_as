package Shmidt.lesson12_2_JDBC.task2.Movies;

import Shmidt.lesson12_2_JDBC.task2.Director.Director;

import java.time.LocalDate;

public class Movie {
    private int id;
    private String title;
    private String genre;
    private LocalDate release;
    private Director director;

    public Movie(int id, String title, String genre, LocalDate release, Director director) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.release = release;
        this.director = director;
    }
//region getters/setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getRelease() {
        return release;
    }

    public void setRelease(LocalDate release) {
        this.release = release;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    //endregion
    @Override
    public String toString() {
        return String.format("%d %s %s %s %s", id, title, genre, release, director.getId() + "(" + director.getLastName() + ")");
    }
}
