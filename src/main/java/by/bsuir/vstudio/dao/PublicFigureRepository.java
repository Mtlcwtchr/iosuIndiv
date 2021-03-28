package by.bsuir.vstudio.dao;

import by.bsuir.vstudio.entity.Niche;
import by.bsuir.vstudio.entity.OscarStatus;
import by.bsuir.vstudio.entity.PublicFigure;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PublicFigureRepository extends CrudRepository<PublicFigure, Integer> {
    List<PublicFigure> findAllByNiche(Niche niche);
    List<PublicFigure> findAllByOscarStatus(OscarStatus oscarStatus);
}
