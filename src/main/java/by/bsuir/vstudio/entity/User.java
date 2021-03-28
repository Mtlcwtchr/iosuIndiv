package by.bsuir.vstudio.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends EntityObject {

    private String username;
    private String password;
    @Column(name = "is_promoted")
    private boolean isPromoted;

    public User() { }

    public User(String username, String password, boolean isPromoted) {
        this.username = username;
        this.password = password;
        this.isPromoted = isPromoted;
    }

    public User(int id, String username, String password, boolean isPromoted) {
        super(id);
        this.username = username;
        this.password = password;
        this.isPromoted = isPromoted;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPromoted() {
        return isPromoted;
    }

    public void setPromoted(boolean promoted) {
        isPromoted = promoted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return isPromoted == user.isPromoted && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), username, password, isPromoted);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add(super.toString())
                .add("username='" + username + "'")
                .add("password='" + password + "'")
                .add("isPromoted=" + isPromoted)
                .toString();
    }
}
