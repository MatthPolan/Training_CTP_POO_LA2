package w.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@Table(name = "medicaments", schema = "ctp_medicament", catalog = "")
public class E_Medicaments {
    @Basic
    @Column(name = "nom", nullable = true, length = -1)
    private String nom;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "e_medicaments")
    private List<E_PriseMedicaments> medicaments;

    @Override
    public String toString() {
        return "E_Medicaments{" +
                "nom='" + nom + '\'' +
                ", id=" + id +
                '}';
    }
}
