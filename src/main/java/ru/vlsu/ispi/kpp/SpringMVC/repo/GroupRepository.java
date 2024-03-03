package ru.vlsu.ispi.kpp.SpringMVC.repo;

import org.springframework.data.repository.ListCrudRepository;
import ru.vlsu.ispi.kpp.SpringMVC.model.Group;

import java.util.Optional;

public interface GroupRepository extends ListCrudRepository<Group, Long> {
    Optional<Group> findByName(String name);
}
