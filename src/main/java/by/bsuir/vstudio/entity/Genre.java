package by.bsuir.vstudio.entity;

import javax.persistence.Entity;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
public class Genre extends EntityObject {

    private String title;

    public Genre() { }

    public Genre(String title) {
        this.title = title;
    }

    public Genre(int id, String title) {
        super(id);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Genre genre = (Genre) o;
        return Objects.equals(title, genre.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Genre.class.getSimpleName() + "[", "]")
                .add(super.toString())
                .add("title='" + title + "'")
                .toString();
    }
}
