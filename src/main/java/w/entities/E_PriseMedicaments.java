package w.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@Table(name = "prise_medicaments", schema = "ctp_medicament", catalog = "")
public class E_PriseMedicaments {
    @Basic
    @Column(name = "date", nullable = false)
    private Date date;
    @Basic
    @Column(name = "heure", nullable = false, length = -1)
    private String heure;
    @Basic
    @Column(name = "quantite", nullable = true)
    private Integer quantite;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_prise", nullable = false)
    private int idPrise;


    @Column(name = "id_medicament", nullable = false)
    private int idMedicament;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_medicament", referencedColumnName = "id",insertable = false, updatable = false)
    private E_Medicaments e_medicaments ;

    @Override
    public String toString() {
        return "E_PriseMedicaments{" +
                "date=" + date +
                ", heure='" + heure + '\'' +
                ", quantite=" + quantite +
                ", idPrise=" + idPrise +
                ", idMedicament=" + idMedicament +
                ", e_medicaments=" + e_medicaments +
                '}';
    }
}
