package by.bsuir.vstudio.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "personalized_group")
public class PersonalizedGroup extends EntityObject {

    @Column(name = "age_from")
    private int ageFrom;
    @Column(name = "age_to")
    private int ageTo;
    @Column(name = "significance_status")
    private SignificanceStatus significanceStatus;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "genre_of_personalized_group",
            joinColumns = @JoinColumn(name = "personalized_group_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id")
    )
    private List<Genre> genres;

    @ManyToMany
    @JoinTable(
            name = "production_company_of_personalized_group",
            joinColumns = @JoinColumn(name = "personalized_group_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "production_company_id", referencedColumnName = "id")
    )
    private List<ProductionCompany> productionCompanies;

    @ManyToMany
    @JoinTable(
            name = "public_figure_of_personalized_group",
            joinColumns = @JoinColumn(name = "personalized_group_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "public_figure_id", referencedColumnName = "id")
    )
    private List<PublicFigure> publicFigures;

    public PersonalizedGroup() { }

    public PersonalizedGroup(int ageFrom, int ageTo, SignificanceStatus significanceStatus, List<Genre> genres, List<ProductionCompany> productionCompanies, List<PublicFigure> publicFigures) {
        this.ageFrom = ageFrom;
        this.ageTo = ageTo;
        this.significanceStatus = significanceStatus;
        this.genres = genres;
        this.productionCompanies = productionCompanies;
        this.publicFigures = publicFigures;
    }

    public PersonalizedGroup(int id, int ageFrom, int ageTo, SignificanceStatus significanceStatus, List<Genre> genres, List<ProductionCompany> productionCompanies, List<PublicFigure> publicFigures) {
        super(id);
        this.ageFrom = ageFrom;
        this.ageTo = ageTo;
        this.significanceStatus = significanceStatus;
        this.genres = genres;
        this.productionCompanies = productionCompanies;
        this.publicFigures = publicFigures;
    }

    public int getAgeFrom() {
        return ageFrom;
    }

    public void setAgeFrom(int ageFrom) {
        this.ageFrom = ageFrom;
    }

    public int getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(int ageTo) {
        this.ageTo = ageTo;
    }

    public SignificanceStatus getSignificanceStatus() {
        return significanceStatus;
    }

    public void setSignificanceStatus(SignificanceStatus significanceStatus) {
        this.significanceStatus = significanceStatus;
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
        PersonalizedGroup that = (PersonalizedGroup) o;
        return ageFrom == that.ageFrom && ageTo == that.ageTo && significanceStatus == that.significanceStatus && Objects.equals(genres, that.genres) && Objects.equals(productionCompanies, that.productionCompanies) && Objects.equals(publicFigures, that.publicFigures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ageFrom, ageTo, significanceStatus, genres, productionCompanies, publicFigures);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PersonalizedGroup.class.getSimpleName() + "[", "]")
                .add(super.toString())
                .add("ageFrom=" + ageFrom)
                .add("ageTo=" + ageTo)
                .add("significanceStatus=" + significanceStatus)
                .add("genres=" + genres)
                .add("productionCompanies=" + productionCompanies)
                .add("publicFigures=" + publicFigures)
                .toString();
    }
}
