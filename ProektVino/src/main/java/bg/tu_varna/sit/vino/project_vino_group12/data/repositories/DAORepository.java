package bg.tu_varna.sit.vino.project_vino_group12.data.repositories;

import java.util.List;

public interface DAORepository<T> {
    void save(T obj);
    void update(T obj);
    void delete(T obj);
    T getById(Integer id);
    List<T> getAll();
}
