package by.bsuir.vstudio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "production_company")
public class ProductionCompany extends EntityObject{

    private String title;
    @Column(name = "foundation_date")
    private LocalDate foundationDate;
    private String location;

    public ProductionCompany() { }

    public ProductionCompany(String title, LocalDate foundationDate, String location) {
        this.title = title;
        this.foundationDate = foundationDate;
        this.location = location;
    }

    public ProductionCompany(int id, String title, LocalDate foundationDate, String location) {
        super(id);
        this.title = title;
        this.foundationDate = foundationDate;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(LocalDate foundationDate) {
        this.foundationDate = foundationDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProductionCompany that = (ProductionCompany) o;
        return Objects.equals(title, that.title) && Objects.equals(foundationDate, that.foundationDate) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, foundationDate, location);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ProductionCompany.class.getSimpleName() + "[", "]")
                .add(super.toString())
                .add("title='" + title + "'")
                .add("foundationDate=" + foundationDate)
                .add("location='" + location + "'")
                .toString();
    }
}
