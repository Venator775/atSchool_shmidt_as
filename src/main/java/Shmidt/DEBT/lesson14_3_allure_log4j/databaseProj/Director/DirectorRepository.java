package Shmidt.DEBT.lesson14_3_allure_log4j.databaseProj.Director;

import java.util.List;

public interface DirectorRepository {
    Director get(int id);

    void save(Director director);

    void delete(Director director);

    List<Director> get(List<String> genres);
}
