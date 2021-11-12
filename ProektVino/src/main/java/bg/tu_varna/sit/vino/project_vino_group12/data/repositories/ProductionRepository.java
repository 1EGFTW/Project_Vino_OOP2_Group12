package bg.tu_varna.sit.vino.project_vino_group12.data.repositories;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Production;

import java.util.List;
import java.util.Optional;

public class ProductionRepository implements DAORepository<Production> {

    @Override
    public void save(Production obj) {

    }

    @Override
    public void update(Production obj) {

    }

    @Override
    public void delete(Production obj) {

    }

    @Override
    public Optional<Production> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Production> getAll() {
        return null;
    }
}
