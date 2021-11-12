package bg.tu_varna.sit.vino.project_vino_group12.data.repositories;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Operator;

import java.util.List;
import java.util.Optional;

public class OperatorRepository implements DAORepository<Operator>{

    @Override
    public void save(Operator obj) {

    }

    @Override
    public void update(Operator obj) {

    }

    @Override
    public void delete(Operator obj) {

    }

    @Override
    public Optional<Operator> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Operator> getAll() {
        return null;
    }
}
