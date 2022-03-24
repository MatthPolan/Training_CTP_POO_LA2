package w.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "symptome", schema = "ctp_medicament", catalog = "")
public class E_Symptome extends E_Entity {
    @Basic
    @Column(name = "date", nullable = false)
    private Date date;
    @Basic
    @Column(name = "heure", nullable = false)
    private int heure;
    @Basic
    @Column(name = "duree", nullable = true)
    private int duree;

    @Basic
    @Column(name = "nom", nullable = false, length = -1)
    private String nom;
    @Basic
    @Column(name = "description", nullable = false, length = -1)
    private String description;

    @Override
    public String toString() {
        return "E_Symptome{" +
                "date=" + date +
                ", heure=" + heure +
                ", duree=" + duree +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

