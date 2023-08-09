package Shmidt.DEBT.lesson12_2_JDBC.task2.Director;

import java.util.List;

public interface DirectorRepository {
    Director get(int id);

    void save(Director director);

    void delete(Director director);

    List<Director> get(List<String> genres);
}
