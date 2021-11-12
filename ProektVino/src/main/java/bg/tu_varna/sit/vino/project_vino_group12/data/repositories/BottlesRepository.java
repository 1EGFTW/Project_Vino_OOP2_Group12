package bg.tu_varna.sit.vino.project_vino_group12.data.repositories;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Bottles;

import java.util.List;
import java.util.Optional;

public class BottlesRepository implements DAORepository<Bottles>{

    @Override
    public void save(Bottles obj) {

    }

    @Override
    public void update(Bottles obj) {

    }

    @Override
    public void delete(Bottles obj) {

    }

    @Override
    public Optional<Bottles> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Bottles> getAll() {
        return null;
    }
}
