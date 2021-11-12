package bg.tu_varna.sit.vino.project_vino_group12.data.repositories;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Wines;

import java.util.List;
import java.util.Optional;

public class WinesRepository implements DAORepository<Wines> {

    @Override
    public void save(Wines obj) {

    }

    @Override
    public void update(Wines obj) {

    }

    @Override
    public void delete(Wines obj) {

    }

    @Override
    public Optional<Wines> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Wines> getAll() {
        return null;
    }
}
