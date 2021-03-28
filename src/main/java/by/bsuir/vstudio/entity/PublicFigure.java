package by.bsuir.vstudio.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "public_figure")
public class PublicFigure extends EntityObject {

    @ManyToOne
    @JoinColumn(name = "personality_id")
    private PublicFigurePersonality personality;
    private Niche niche;
    @Column(name = "oscar_status")
    private OscarStatus oscarStatus;

    public PublicFigure() { }

    public PublicFigure(PublicFigurePersonality personality, Niche niche, OscarStatus oscarStatus) {
        this.personality = personality;
        this.niche = niche;
        this.oscarStatus = oscarStatus;
    }

    public PublicFigure(int id, PublicFigurePersonality personality, Niche niche, OscarStatus oscarStatus) {
        super(id);
        this.personality = personality;
        this.niche = niche;
        this.oscarStatus = oscarStatus;
    }

    public Niche getNiche() {
        return niche;
    }

    public void setNiche(Niche niche) {
        this.niche = niche;
    }

    public OscarStatus getOscarStatus() {
        return oscarStatus;
    }

    public void setOscarStatus(OscarStatus oscarStatus) {
        this.oscarStatus = oscarStatus;
    }

    public PublicFigurePersonality getPersonality() {
        return personality;
    }

    public void setPersonality(PublicFigurePersonality personality) {
        this.personality = personality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PublicFigure that = (PublicFigure) o;
        return Objects.equals(personality, that.personality) && niche == that.niche && oscarStatus == that.oscarStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), personality, niche, oscarStatus);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PublicFigure.class.getSimpleName() + "[", "]")
                .add(super.toString())
                .add("personality=" + personality)
                .add("niche=" + niche)
                .add("oscarStatus=" + oscarStatus)
                .toString();
    }

    @PostLoad
    void postLoad() {
        if(personality.getName().toLowerCase(Locale.ROOT).contains("wiseau")) {
            System.out.println("Oh hi Mark");
        }
    }
}
