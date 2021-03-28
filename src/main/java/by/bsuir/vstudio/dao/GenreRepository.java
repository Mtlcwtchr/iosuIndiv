package by.bsuir.vstudio.dao;

import by.bsuir.vstudio.entity.Genre;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GenreRepository extends CrudRepository<Genre, Integer> {
    Optional<Genre> findByTitle(String title);
}
