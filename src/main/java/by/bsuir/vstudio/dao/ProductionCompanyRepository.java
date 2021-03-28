package by.bsuir.vstudio.dao;

import by.bsuir.vstudio.entity.ProductionCompany;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductionCompanyRepository extends CrudRepository<ProductionCompany, Integer> {
    Optional<ProductionCompany> findByTitle(String title);
    List<ProductionCompany> findAllByLocation(String location);
}
