package by.bsuir.vstudio.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "public_figure_personality")
public class PublicFigurePersonality extends EntityObject {

    private String name;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "death_date")
    private LocalDate deathDate;
    @Column(name = "native_city")
    private String nativeCity;

    public PublicFigurePersonality() { }

    public PublicFigurePersonality(String name, LocalDate birthDate, LocalDate deathDate, String nativeCity) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.nativeCity = nativeCity;
    }

    public PublicFigurePersonality(int id, String name, LocalDate birthDate, LocalDate deathDate, String nativeCity) {
        super(id);
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.nativeCity = nativeCity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public String getNativeCity() {
        return nativeCity;
    }

    public void setNativeCity(String localCity) {
        this.nativeCity = localCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PublicFigurePersonality that = (PublicFigurePersonality) o;
        return Objects.equals(name, that.name) && Objects.equals(birthDate, that.birthDate) && Objects.equals(deathDate, that.deathDate) && Objects.equals(nativeCity, that.nativeCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, birthDate, deathDate, nativeCity);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PublicFigurePersonality.class.getSimpleName() + "[", "]")
                .add(super.toString())
                .add("name='" + name + "'")
                .add("birthDate=" + birthDate)
                .add("deathDate=" + deathDate)
                .add("localCity='" + nativeCity + "'")
                .toString();
    }
}
