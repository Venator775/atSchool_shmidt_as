package Shmidt.DEBT.lesson12_2_JDBC.task2.Movies;

import Shmidt.DEBT.lesson12_2_JDBC.task2.Director.Director;

import java.util.List;

public interface MovieRepository {
    Movie get(int id);

    void save(Movie movie);

    void delete(Movie movie);

    List<Movie> get(Director d);
}
