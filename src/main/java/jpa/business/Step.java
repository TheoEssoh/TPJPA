package jpa.business;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Step implements Serializable {

    private long id;
    private String name;
    private List<KanbanBoard> kanbanBoards;
    private List<Card> cards;

    @Id @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @ManyToMany(mappedBy = "steps")
    public List<KanbanBoard> getKanbanBoards() {
        return kanbanBoards;
    }

    public void setKanbanBoards(List<KanbanBoard> kanbanBoards) {
        this.kanbanBoards = kanbanBoards;
    }

    @OneToMany
    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Step)) return false;
        Step step = (Step) o;
        return getId() == step.getId() && getName().equals(step.getName()) && getKanbanBoards().equals(step.getKanbanBoards()) && getCards().equals(step.getCards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getKanbanBoards(), getCards());
    }

    @Override
    public String toString() {
        return "Step{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kanbanBoards=" + kanbanBoards +
                ", cards=" + cards +
                '}';
    }
}
