package jpa.business;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "STEP")
/*@NamedQueries(
        {@NamedQuery(name = "AllSteps", query = "SELECT s FROM Step as s"),
                @NamedQuery(name = "AllCardsByStep",query = "SELECT  s.cards FROM Step as s WHERE Step.id=Card.step"),
                @NamedQuery(name = "AllUsersWhoHaveCardS", query = "SELECT DISTINCT c.userAffected FROM Card as c"),

                @NamedQuery(name = "UsersInStepOne", query = "SELECT DISTINCT c.userAffected FROM Card as c WHERE c.step ='en attente'  "),
                @NamedQuery(name = "UsersInStepTwo", query = "SELECT DISTINCT c.userAffected FROM Card as c WHERE c.step ='en cours'  "),
                @NamedQuery(name = "UsersInStepThree", query = "SELECT DISTINCT c.userAffected FROM Card as c WHERE c.step ='réalisé'  "),
                // @NamedQuery(name = "AllUsersWhoHaveCardS1", query = "SELECT c.user FROM Card as c"),
                // @NamedQuery(name = "AllUsersWhoHaveCardS2", query = "SELECT c.user FROM Card as c")
        }
)*/
public class Step implements Serializable {

    private long id;
    private String name;
    private List<KanbanBoard> kanbanBoards;
    private List<Card> cards;

    public Step() {
    }

    public Step(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Step(long id, String name, List<KanbanBoard> kanbanBoards, List<Card> cards) {
        this.id = id;
        this.name = name;
        this.kanbanBoards = kanbanBoards;
        this.cards = cards;
    }





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

    @OneToMany(mappedBy = "step")
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
