package jpa.business;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class KanbanBoard implements Serializable {

    private Long id;
    private String name;
    private List<Step> steps;
    private User owner;


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

    @OneToMany
    @JoinColumn(name = "KanbanId")
    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    @ManyToOne
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KanbanBoard)) return false;
        KanbanBoard that = (KanbanBoard) o;
        return getId().equals(that.getId()) && getName().equals(that.getName()) && getSteps().equals(that.getSteps()) && getOwner().equals(that.getOwner());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSteps(), getOwner());
    }

    @Override
    public String toString() {
        return "KanbanBoard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", steps=" + steps +
                ", owner=" + owner +
                '}';
    }
}
