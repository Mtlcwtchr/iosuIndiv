package by.bsuir.vstudio.entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class Movie extends EntityObject {

    private String title;
    @Column(name = "release_date")
    private Date releaseDate;
    @Column(name = "age_rating")
    private int ageRating;
    @Column(name = "has_oscar")
    private boolean hasOscar;
    private int rating;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "genre_of_movie",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id")
    )
    private List<Genre> genres;

    @ManyToMany
    @JoinTable(
            name = "production_company_of_movie",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "production_company_id", referencedColumnName = "id")
    )
    private List<ProductionCompany> productionCompanies;

    @ManyToMany
    @JoinTable(
            name = "public_figure_of_movie",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "public_figure_id", referencedColumnName = "id")
    )
    private List<PublicFigure> publicFigures;

    public Movie() { }

    public Movie(String title, Date releaseDate, int ageRating, boolean hasOscar, int rating) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.ageRating = ageRating;
        this.hasOscar = hasOscar;
        this.rating = rating;
    }

    public Movie(String title, Date releaseDate, int ageRating, boolean hasOscar, int rating, List<Genre> genres, List<ProductionCompany> productionCompanies, List<PublicFigure> publicFigures) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.ageRating = ageRating;
        this.hasOscar = hasOscar;
        this.rating = rating;
        this.genres = genres;
        this.productionCompanies = productionCompanies;
        this.publicFigures = publicFigures;
    }

    public Movie(int id, String title, Date releaseDate, int ageRating, boolean hasOscar, int rating, List<Genre> genres, List<ProductionCompany> productionCompanies, List<PublicFigure> publicFigures) {
        super(id);
        this.title = title;
        this.releaseDate = releaseDate;
        this.ageRating = ageRating;
        this.hasOscar = hasOscar;
        this.rating = rating;
        this.genres = genres;
        this.productionCompanies = productionCompanies;
        this.publicFigures = publicFigures;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }

    public boolean isHasOscar() {
        return hasOscar;
    }

    public void setHasOscar(boolean hasOscar) {
        this.hasOscar = hasOscar;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<ProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(List<ProductionCompany> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public List<PublicFigure> getPublicFigures() {
        return publicFigures;
    }

    public void setPublicFigures(List<PublicFigure> publicFigures) {
        this.publicFigures = publicFigures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Movie movie = (Movie) o;
        return ageRating == movie.ageRating && hasOscar == movie.hasOscar && rating == movie.rating && Objects.equals(title, movie.title) && Objects.equals(releaseDate, movie.releaseDate) && Objects.equals(genres, movie.genres) && Objects.equals(productionCompanies, movie.productionCompanies) && Objects.equals(publicFigures, movie.publicFigures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, releaseDate, ageRating, hasOscar, rating, genres, productionCompanies, publicFigures);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Movie.class.getSimpleName() + "[", "]")
                .add(super.toString())
                .add("title='" + title + "'")
                .add("releaseDate=" + releaseDate)
                .add("ageRating=" + ageRating)
                .add("hasOscar=" + hasOscar)
                .add("rating=" + rating)
                .add("genres=" + genres)
                .add("productionCompanies=" + productionCompanies)
                .add("publicFigures=" + publicFigures)
                .toString();
    }
}
