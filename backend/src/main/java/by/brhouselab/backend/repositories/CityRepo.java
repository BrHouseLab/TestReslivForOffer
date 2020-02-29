package by.brhouselab.backend.repositories;

import by.brhouselab.backend.models.CityEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CityRepo extends CrudRepository<CityEntity, Long> {

    Optional<CityEntity> findFirstByNameLikeIgnoreCase(String name);
}

