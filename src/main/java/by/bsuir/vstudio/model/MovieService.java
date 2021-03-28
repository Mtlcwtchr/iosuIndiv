package by.bsuir.vstudio.model;

import by.bsuir.vstudio.entity.*;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    // Of means all movies matches any operand
    // By means all movies matches all operands at a time

    Optional<Movie> movieByTitle(String title);
    List<Movie> listMovies();
    List<Movie> moviesHasOscar();
    List<Movie> moviesOfGenres(List<Genre> genres);
    List<Movie> moviesByGenres(List<Genre> genres);
    List<Movie> moviesWithPersonsInvolved(List<PublicFigure> publicFigures);
    List<Movie> moviesOfPersonsInvolved(List<PublicFigure> publicFigures);
    List<Movie> moviesByCompanies(List<ProductionCompany> productionCompanies);
    List<Movie> moviesOfCompanies(List<ProductionCompany> productionCompanies);
    boolean hasOscar(Movie movie);
}
