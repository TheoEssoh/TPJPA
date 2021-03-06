package jpa.business;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity (name = "tag")
public class Tag implements Serializable {
    private Long id;
    private String level;
    private String AvailabilityLevel;
    private String label;
    private int Boards;
    private List<Card> cards;

    public Tag( String label) {
        this.id = getId();
        this.label = label;
    }

    public Tag(String level, String availabilityLevel, String label, int boards) {
        this.id = getId();
        this.level = level;
        AvailabilityLevel = availabilityLevel;
        this.label = label;
        Boards = boards;
    }

    public Tag() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAvailabilityLevel() {
        return AvailabilityLevel;
    }

    public void setAvailabilityLevel(String availabilityLevel) {
        AvailabilityLevel = availabilityLevel;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getBoards() {
        return Boards;
    }

    public void setBoards(int boards) {
        Boards = boards;
    }
    @ManyToMany
    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tag)) return false;
        Tag tag = (Tag) o;
        return getBoards() == tag.getBoards() && getId().equals(tag.getId()) && getLevel().equals(tag.getLevel()) && getAvailabilityLevel().equals(tag.getAvailabilityLevel()) && getLabel().equals(tag.getLabel()) && getCards().equals(tag.getCards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLevel(), getAvailabilityLevel(), getLabel(), getBoards(), getCards());
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", level='" + level + '\'' +
                ", AvailabilityLevel='" + AvailabilityLevel + '\'' +
                ", label='" + label + '\'' +
                ", Boards=" + Boards +
                '}';
    }
}
