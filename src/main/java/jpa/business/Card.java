package jpa.business;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity(name = "card")
public class Card implements Serializable {

    private Long id;
    private String label;
    private Long deadline;
    private String timeToDo;
    private String url;
    private String note;
    private List<CardUser> cardUsers;
    private String lieu;
    private List<Tag> tags;
    private Section section;
    private boolean enabled;

    public Card( String label) {
        this.setEnabled(true);
        this.id = getId();
        this.label = label;
    }

    public Card( String label, List<CardUser> cardUsers) {
        this.setEnabled(true);
        this.id = getId();
        this.label = label;
        this.cardUsers = cardUsers;
    }

    public Card(String label, Long deadline, List<CardUser> cardUsers,
                List<Tag> tags, Section section) {
        this.setEnabled(true);
        this.id = getId();
        this.label = label;
        this.deadline = deadline;
        this.cardUsers = cardUsers;
        this.tags = tags;
        this.section = section;
    }

    public Card() {
        this.setEnabled(true);

    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getDeadline() {
        return deadline;
    }

    public void setDeadline(Long deadline) {
        this.deadline = deadline;
    }


    public String getTimeToDo() {
        return timeToDo;
    }

    public void setTimeToDo(String timeToDo) {
        this.timeToDo = timeToDo;
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

    @OneToMany(mappedBy ="card")
    public List<CardUser> getCardUsers() {
        return cardUsers;
    }

    public void setCardUsers(List<CardUser> cardUsers) {
        this.cardUsers = cardUsers;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    @ManyToMany(mappedBy = "cards")
    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @ManyToOne
    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return isEnabled() == card.isEnabled() && getId().equals(card.getId())
                && getLabel().equals(card.getLabel()) && getDeadline().equals(card.getDeadline())
                && getTimeToDo().equals(card.getTimeToDo()) && getUrl().equals(card.getUrl())
                && getNote().equals(card.getNote()) && getCardUsers().equals(card.getCardUsers())
                && getLieu().equals(card.getLieu()) && getTags().equals(card.getTags())
                && getSection().equals(card.getSection());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLabel(), getDeadline(), getTimeToDo(), getUrl(),
                getNote(), getCardUsers(), getLieu(), getTags(), getSection(), isEnabled());
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", deadline=" + deadline +
                ", timeToDo='" + timeToDo + '\'' +
                ", url='" + url + '\'' +
                ", note='" + note + '\'' +
                ", lieu='" + lieu + '\'' +
                ", tags=" + tags +
                ", enabled=" + enabled +
                '}';
    }
}

