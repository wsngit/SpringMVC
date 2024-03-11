package ru.vlsu.ispi.kpp.SpringMVC.repo;

import org.springframework.data.repository.ListCrudRepository;
import ru.vlsu.ispi.kpp.SpringMVC.model.Group;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends ListCrudRepository<Group, Long> {
    List<Group> findAllByName(String name);
    Optional<Group> findByName(String name);
}
