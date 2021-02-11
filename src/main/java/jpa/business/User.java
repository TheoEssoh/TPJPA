package jpa.business;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class User implements Serializable {

    private String lastName;
    private String firstName;
    private String email;
    private List<Card> cards;

    public User() {
    }



    public User(String lastName, String firstName, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }

    public User(String lastName, String firstName, String email, List<Card> cards) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.cards = cards;
    }




    @Id
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


   public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @OneToMany(mappedBy = "userAffected")
    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getLastName().equals(user.getLastName()) && getFirstName().equals(user.getFirstName()) && getEmail().equals(user.getEmail()) && getCards().equals(user.getCards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLastName(), getFirstName(), getEmail(), getCards());
    }

    @Override
    public String toString() {
        return "User{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", cards=" + cards +
                '}';
    }
}
