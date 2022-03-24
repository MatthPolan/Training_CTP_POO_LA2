package w.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@Table(name = "symptome", schema = "ctp_medicament", catalog = "")
public class E_Symptome {
    @Basic
    @Column(name = "date", nullable = false)
    private Date date;
    @Basic
    @Column(name = "heure", nullable = false)
    private Integer heure;
    @Basic
    @Column(name = "duree", nullable = true)
    private Integer duree;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "nom", nullable = false, length = -1)
    private String nom;
    @Basic
    @Column(name = "description", nullable = false, length = -1)
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    private E_PriseMedicaments id_prise;
}
