package Shmidt.DEBT.lesson14_3_allure_log4j.databaseProj.Movies;

import Shmidt.DEBT.lesson14_3_allure_log4j.databaseProj.Director.Director;

import java.util.List;

public interface MovieRepository {
    Movie get(int id);

    void save(Movie movie);

    void delete(Movie movie);

    List<Movie> get(Director d);
}
