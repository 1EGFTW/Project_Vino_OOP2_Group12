package bg.tu_varna.sit.vino.project_vino_group12.data.repositories;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.SortColor;

import java.util.List;
import java.util.Optional;

public class SortColorRepository implements DAORepository<SortColor>{

    @Override
    public void save(SortColor obj) {

    }

    @Override
    public void update(SortColor obj) {

    }

    @Override
    public void delete(SortColor obj) {

    }

    @Override
    public Optional<SortColor> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<SortColor> getAll() {
        return null;
    }
}
