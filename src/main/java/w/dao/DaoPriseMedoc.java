package w.dao;


import w.entities.E_PriseMedicaments;

import java.util.Date;
import java.util.List;

public interface DaoPriseMedoc extends Dao<E_PriseMedicaments> {
    List<Date> consommationMedicament(int idMedicament);
}
