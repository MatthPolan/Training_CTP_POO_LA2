package w.jpaDao;


import w.dao.DaoSymptome;
import w.entities.E_Symptome;

public class JpaDaoSymptome extends JpaDao<E_Symptome> implements DaoSymptome {
    private static JpaDaoSymptome jpaDaoSymptome;

    private JpaDaoSymptome() {
    }
    public static JpaDaoSymptome getInstance(){
        if(jpaDaoSymptome==null){
            jpaDaoSymptome = new JpaDaoSymptome();
        }
        return jpaDaoSymptome;
    }
}
