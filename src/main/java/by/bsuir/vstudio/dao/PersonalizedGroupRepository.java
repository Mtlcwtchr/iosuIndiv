package by.bsuir.vstudio.dao;

import by.bsuir.vstudio.entity.*;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonalizedGroupRepository extends CrudRepository<PersonalizedGroup, Integer> {
    List<PersonalizedGroup> findAllByAgeFromAfterAndAgeToBefore(int ageFrom, int ageTo);
    List<PersonalizedGroup> findAllBySignificanceStatus(SignificanceStatus status);
    List<PersonalizedGroup> findAllByGenresAndProductionCompaniesAndPublicFigures(List<Genre> genres,
                                                                                  List<ProductionCompany> productionCompanies,
                                                                                  List<PublicFigure> publicFigures);
    List<PersonalizedGroup> findAllByGenres(List<Genre> genres);
    List<PersonalizedGroup> findAllByProductionCompanies(List<ProductionCompany> productionCompanies);
    List<PersonalizedGroup> findAllByPublicFigures(List<PublicFigure> publicFigures);
    List<PersonalizedGroup> findAllByGenresOrProductionCompaniesOrPublicFigures(List<Genre> genres,
                                                                                List<ProductionCompany> productionCompanies,
                                                                                List<PublicFigure> publicFigures);
}
