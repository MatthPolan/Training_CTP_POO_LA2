package w.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public abstract class E_Entity {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Override
    public String toString() {
        return "E_Entity{" +
                "id=" + id +
                '}';
    }
}
