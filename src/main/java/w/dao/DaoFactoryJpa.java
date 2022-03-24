package w.dao;


import w.jpaDao.JpaDaoPriseMedoc;
import w.jpaDao.JpaDaoSymptome;

public class DaoFactoryJpa extends DaoFactory {
    public DaoPriseMedoc getDaoPriseMedoc() {
        return JpaDaoPriseMedoc.getInstance();
    }

    public DaoSymptome getDaoRapportSymptome() {
        return JpaDaoSymptome.getInstance();
    }

}
