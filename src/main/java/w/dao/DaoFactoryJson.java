package w.dao;

import w.JsonDao.JsonDaoSymptome;

public class DaoFactoryJson extends DaoFactory{

    public DaoPriseMedoc getDaoPriseMedoc() {
        return null;
    }

    public DaoSymptome getDaoRapportSymptome() {
        return JsonDaoSymptome.getInstance();
    }
}
