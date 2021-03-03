package jpa.business;

import javax.persistence.*;
import java.io.Serializable;

import java.util.List;
import java.util.Objects;

@Entity
public class KanbanBoard implements Serializable {

    private Long id;
    private String name;
    private List<Section> sections;

    public KanbanBoard( String name) {
        this.id = getId();
        this.name = name;
    }

    public KanbanBoard( String name, List<Section> sections) {
        this.id = getId();
        this.name = name;
        this.sections = sections;
    }

    public KanbanBoard() {

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

    @OneToMany(mappedBy ="kanbanBoard")
    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KanbanBoard)) return false;
        KanbanBoard that = (KanbanBoard) o;
        return getId().equals(that.getId()) && getName().equals(that.getName()) && getSections().equals(that.getSections());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSections());
    }

    @Override
    public String toString() {
        return "KanbanBoard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
