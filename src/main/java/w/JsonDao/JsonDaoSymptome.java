package w.JsonDao;

import w.dao.DaoSymptome;
import w.entities.E_Symptome;
import w.jpaDao.JpaDao;

public class JsonDaoSymptome extends JsonDao<E_Symptome> implements DaoSymptome {
    private JsonDaoSymptome() {
    }
    private static JsonDaoSymptome jpaDaoSymptome;

    public static JsonDaoSymptome getInstance(){
        if(jpaDaoSymptome==null){
            jpaDaoSymptome = new JsonDaoSymptome();
        }
        return jpaDaoSymptome;
    }
}
