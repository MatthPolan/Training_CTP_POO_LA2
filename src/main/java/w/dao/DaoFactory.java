package w.dao;


import w.model.PersistenceType;

public abstract class DaoFactory {
    public abstract DaoPriseMedoc getDaoPriseMedoc();

    public abstract DaoSymptome getDaoRapportSymptome();

    public static DaoFactory getDaoFactory(PersistenceType type) {
        if (type == PersistenceType.JPA) {
            return new DaoFactoryJpa();
        }
        if (type == PersistenceType.JSON) {
            return new DaoFactoryJson();
        }
        throw new IllegalArgumentException("Persistance Type not found");
    }

}
