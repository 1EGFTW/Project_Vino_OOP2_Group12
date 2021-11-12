package bg.tu_varna.sit.vino.project_vino_group12.data.repositories;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Grape;

import java.util.List;
import java.util.Optional;

public class GrapeRepository implements DAORepository<Grape> {

    @Override
    public void save(Grape obj) {

    }

    @Override
    public void update(Grape obj) {

    }

    @Override
    public void delete(Grape obj) {

    }

    @Override
    public Optional<Grape> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Grape> getAll() {
        return null;
    }
}
