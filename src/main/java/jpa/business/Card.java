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
    private Date deadline;
    private Date timeToDo;
    private String url;
    private String note;
    private List<CardUser> cardUsers;
    private String location;
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

    public Card( String label, Date deadline, Date timeToDo, String url,
                String note, String location) {
        this.id = getId();
        this.label = label;
        this.deadline = deadline;
        this.timeToDo = timeToDo;
        this.url = url;
        this.note = note;
        this.location = location;
        this.setEnabled(true);
    }

    public Card(String label, Date deadline, List<CardUser> cardUsers,
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

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }


    public Date getTimeToDo() {
        return timeToDo;
    }

    public void setTimeToDo(Date timeToDo) {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String lieu) {
        this.location = lieu;
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
                && getLocation().equals(card.getLocation()) && getTags().equals(card.getTags())
                && getSection().equals(card.getSection());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLabel(), getDeadline(), getTimeToDo(), getUrl(),
                getNote(), getCardUsers(), getLocation(), getTags(), getSection(), isEnabled());
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
                ", lieu='" + location + '\'' +
                ", tags=" + tags +
                ", enabled=" + enabled +
                '}';
    }
}

