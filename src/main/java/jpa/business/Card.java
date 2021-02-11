package jpa.business;

import javax.persistence.*;
import javax.swing.text.html.HTML;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Card implements Serializable {

    private Long id;
    private String name;
    private int durationInMinutes;
    private Date deadline;
    private User userAffected;
    //private List<HTML.Tag> tags;
    private  String location;
    private String url;
    private String note;

    public Card() {
    }

    public Card(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Card(Long id, String name, int durationInMinutes, Date deadline, User userAffected,
                String location, String url, String note) {
        this.id = id;
        this.name = name;
        this.durationInMinutes = durationInMinutes;
        this.deadline = deadline;
        this.userAffected = userAffected;
        this.location = location;
        this.url = url;
        this.note = note;
    }

    @Id
     @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @ManyToOne
    public User getUserAffected() {
        return userAffected;
    }

    public void setUserAffected(User userAffected) {
        this.userAffected = userAffected;
    }
/*

    public List<HTML.Tag> getTags() {
        return tags;
    }

    public void setTags(List<HTML.Tag> tags) {
        this.tags = tags;
    }
*/

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return getDurationInMinutes() == card.getDurationInMinutes() && getId().equals(card.getId())
                && getName().equals(card.getName()) && getDeadline().equals(card.getDeadline()) &&
                getUserAffected().equals(card.getUserAffected())  && getLocation().equals(card.getLocation())
                && getUrl().equals(card.getUrl()) && getNote().equals(card.getNote()); //&& getTags().equals(card.getTags())
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDurationInMinutes(), getDeadline(), getUserAffected(), getLocation(), getUrl(), getNote()); //getTags()
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", durationInMinutes=" + durationInMinutes +
                ", deadline=" + deadline +
                ", userAffected=" + userAffected +
               // ", tags=" + tags +
                ", location='" + location + '\'' +
                ", url='" + url + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
