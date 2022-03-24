package w.JsonDao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import w.dao.DaoSymptome;
import w.entities.E_Symptome;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

public class JsonDaoSymptome extends JsonDao<E_Symptome> implements DaoSymptome {
    private JsonDaoSymptome() {
    }

    private static JsonDaoSymptome jpaDaoSymptome;

    public static JsonDaoSymptome getInstance() {
        if (jpaDaoSymptome == null) {
            jpaDaoSymptome = new JsonDaoSymptome();
        }
        return jpaDaoSymptome;
    }

    @Override
    public void exportToJson() {
        Gson gson = new Gson();
        List<E_Symptome> list = findAll(E_Symptome.class);
        HashMap<String, Object> symptomes = new HashMap<>();
        symptomes.put("data", list.toArray());
        Object objArray = symptomes;
        Type listOfClassObject = TypeToken.getParameterized(Object.class, E_Symptome.class).getType();
        String stringJson = gson.toJson(objArray, listOfClassObject);
        try (Writer writer = new FileWriter("Symptome.json")) {
            writer.write(stringJson);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
