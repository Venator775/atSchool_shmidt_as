package Shmidt.lesson12_2_JDBC.task1.Director;

public interface DirectorRepository {
    Director get(int id);

    void save(Director director);

    void delete(Director director);
}
