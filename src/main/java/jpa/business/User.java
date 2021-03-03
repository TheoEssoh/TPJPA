package jpa.business;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity (name = "user")
@Table(
        /*name="user",*/
        uniqueConstraints={
                @UniqueConstraint(name="email", columnNames={"email"})
        })
@NamedQueries(
        {@NamedQuery(name = "All Users", query = "SELECT u FROM user as u"),
              /*  @NamedQuery(name = "All Kanban Owners",query = "SELECT DISTINCT k.owner FROM KanbanBoard as k"),*/
                @NamedQuery(name = "All Users Who Have CardS", query = "SELECT DISTINCT c.cardUsers FROM card as c"),

               // @NamedQuery(name = "UsersInStepOne", query = "SELECT DISTINCT c.userAffected FROM Card as c WHERE c.step ='To do'  "),
               // @NamedQuery(name = "UsersInStepTwo", query = "SELECT DISTINCT c.userAffected FROM Card as c WHERE c.step ='Doing'  "),
               // @NamedQuery(name = "UsersInStepThree", query = "SELECT DISTINCT c.userAffected FROM Card as c WHERE c.step ='Done'  "),
               //@NamedQuery(name = "Number Of Users", query = "SELECT COUNT(u) FROM User as u"),
               // @NamedQuery(name = "AllUsersWhoHaveCardS2", query = "SELECT c.user FROM Card as c")
        }
)
public class User implements Serializable {

    private long idUser;
    private String name;
    private boolean enabled;
    private String email;
    private List<CardUser> cardsUser;

    public User( String name) {
        this.setEnabled(true);
        this.idUser = getIdUser();
        this.name = name;
    }

    public User( String name, String email) {
        this.setEnabled(true);
        this.idUser = getIdUser();
        this.name = name;
        this.email = email;
    }

    public User() {
        this.setEnabled(true);

    }


    @Id
    @GeneratedValue
    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @OneToMany(mappedBy="user")
    public List<CardUser> getCardsUser() {
        return cardsUser;
    }

    public void setCardsUser(List<CardUser> cardsUser) {
        this.cardsUser = cardsUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getIdUser() == user.getIdUser() && isEnabled() == user.isEnabled() && getName().equals(user.getName()) && getEmail().equals(user.getEmail()) && getCardsUser().equals(user.getCardsUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdUser(), getName(), isEnabled(), getEmail(), getCardsUser());
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", name='" + name + '\'' +
                ", enabled=" + enabled +
                ", email='" + email + '}';
    }
}
