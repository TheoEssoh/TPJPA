package jpa.business;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity (name = "section")
public class Section implements Serializable {

    private long id;
    private String label;
    private List<Card> cards;
    private KanbanBoard kanbanBoard;

    public Section( String label) {
        this.id = getId();
        this.label = label;
    }

    public Section() {
        this.id = getId();
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    @OneToMany(mappedBy ="section")
    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
    @ManyToOne
    public KanbanBoard getKanbanBoard() {
        return kanbanBoard;
    }
    public void setKanbanBoard(KanbanBoard kanbanBoard) {
        this.kanbanBoard = kanbanBoard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Section)) return false;
        Section section = (Section) o;
        return getId() == section.getId() && getLabel().equals(section.getLabel()) && getCards().equals(section.getCards()) && getKanbanBoard().equals(section.getKanbanBoard());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLabel(), getCards(), getKanbanBoard());
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", label='" + label+'}';
    }
}