package w.model;

import w.dao.DaoFactory;
import w.dao.DaoSymptome;


public class Test {
    public static void main(String[] args) {
//        DaoRapportSymptome symptomeManager = DaoFactory.getDaoFactory(PersistenceType.JPA).getDaoRapportSymptome();
//        E_RapportSymptome e_rapportSymptome = new E_RapportSymptome();
//        e_rapportSymptome.setDate(new Date(2022,12,03));
//        e_rapportSymptome.setDuree(20);
//        e_rapportSymptome.setHeure(1);
//        E_Symptomes e_symptomes = new E_Symptomes();
//        e_symptomes.setE_rapportSymptome(e_rapportSymptome);
//        e_symptomes.setDescription("j,");
//        e_symptomes.setNom("io");
//        List<E_Symptomes> eSymptomes =new ArrayList<>();
//        eSymptomes.add(e_symptomes);
//        e_rapportSymptome.setE_symptomes(eSymptomes);
//        symptomeManager.create(e_rapportSymptome);
//        symptomeManager.delete(e_rapportSymptome);
        DaoSymptome symptome = DaoFactory.getDaoFactory(PersistenceType.JPA).getDaoRapportSymptome();
        symptome.exportToJson();
        //  symptome.deleteAll(E_Symptome.class);
        //symptome.findAll(E_Symptome.class);
        //System.out.println(symptome.find(E_Symptome.class,1));
        /*E_Symptome e_symptome = new E_Symptome();
        e_symptome.setDate(new Date(1220227200));
        e_symptome.setDescription("aaaaaaauuuuuu noir");
        e_symptome.setHeure(12);
        e_symptome.setId(2);
        e_symptome.setNom("Covid");
        // symptome.create(e_symptome);*/
        //  symptome.update(e_symptome);
        //DaoPriseMedoc daoPriseMedoc = DaoFactory.getDaoFactory(PersistenceType.JPA).getDaoPriseMedoc();

        //        List<Date> dates = daoPriseMedoc.consommationMedicament(62425595);
    }
}
