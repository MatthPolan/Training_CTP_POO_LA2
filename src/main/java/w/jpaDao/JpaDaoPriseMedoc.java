package w.jpaDao;

import w.dao.DaoPriseMedoc;
import w.entities.E_PriseMedicaments;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class JpaDaoPriseMedoc extends JpaDao<E_PriseMedicaments> implements DaoPriseMedoc {
    private static JpaDaoPriseMedoc jpaDaoPriseMedoc;

    private JpaDaoPriseMedoc() {
    }

    public static JpaDaoPriseMedoc getInstance() {
        if (jpaDaoPriseMedoc == null) {
            jpaDaoPriseMedoc = new JpaDaoPriseMedoc();
        }
        return jpaDaoPriseMedoc;
    }

    @Override
    public List<Date> consommationMedicament(int idMedicament) {
        List<Date> tab = new ArrayList<>();
        List<E_PriseMedicaments> list = findAll(E_PriseMedicaments.class);
        list = list.stream().filter(e_priseMedicaments -> e_priseMedicaments.getIdMedicament() == idMedicament).collect(Collectors.toList());
        list.forEach(e_priseMedicaments -> tab.add(e_priseMedicaments.getDate()));
        return tab;
    }
}
