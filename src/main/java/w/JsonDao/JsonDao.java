package w.JsonDao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import w.dao.Dao;
import w.entities.E_Entity;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class JsonDao<T extends E_Entity> implements Dao<T> {
    private String filename = "/home/ig2i/IdeaProjects/try/src/main/resources/";

    @Override
    public Optional<T> find(Class<T> entityClass, int id) {
        JSONParser parser = new JSONParser();
        Gson gson = new Gson();
        JSONObject entity = null;
        try (Reader reader = new FileReader(filename.concat(entityClass.getSimpleName().concat(".json")))) {
            entity = (JSONObject) parser.parse(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONArray data = (JSONArray) entity.get("data");
        Type listOfClassObject = TypeToken.getParameterized(ArrayList.class, entityClass).getType();
        ArrayList<T> one = gson.fromJson(data.toString(), listOfClassObject);
        Optional<T> find = one.stream().filter(t -> t.getId() == id).findFirst();
        if (find != null) {
            return find;
        }
        throw new IllegalArgumentException("id not found");
    }

    @Override
    public void create(T obj) {
        JSONParser parser = new JSONParser();
        Gson gson = new Gson();
        JSONObject entity = null;
        try (Reader reader = new FileReader("/home/ig2i/IdeaProjects/try/src/main/resources/E_Symptome.json")) {
            entity = (JSONObject) parser.parse(reader);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (entity.size() != 0) {
            JSONArray data = (JSONArray) entity.get("data");
            Type listOfClassObject = new TypeToken<ArrayList<T>>() {
            }.getType();
            List<T> one = gson.fromJson(data.toString(), listOfClassObject);
            one.add(obj);
            entity.put("data", one);
        } else {
            List<T> list = new ArrayList<>();
            list.add(obj);
            entity.put("data", list);
        }
        try (Writer writer = new FileWriter("/home/ig2i/IdeaProjects/try/src/main/resources/E_Symptome.json")) {
            gson.toJson(entity, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(T obj) {
        JSONParser parser = new JSONParser();
        JSONObject entity = null;
        try (Reader reader = new FileReader("/home/ig2i/IdeaProjects/try/src/main/resources/E_Symptome.json")) {
            entity = (JSONObject) parser.parse(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONArray data = (JSONArray) entity.get("data");
        Type listOfClassObject = TypeToken.getParameterized(ArrayList.class, obj.getClass()).getType();
        Gson gson = new Gson();
        ArrayList<T> one = gson.fromJson(data.toString(), listOfClassObject);
        one.remove(obj);
        entity.put("data", one);
        try (Writer writer = new FileWriter("/home/ig2i/IdeaProjects/try/src/main/resources/E_Symptome.json")) {
            gson.toJson(entity, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(T obj) {
        JSONParser parser = new JSONParser();
        JSONObject entity = null;
        try (Reader reader = new FileReader("/home/ig2i/IdeaProjects/try/src/main/resources/E_Symptome.json")) {
            entity = (JSONObject) parser.parse(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONArray data = (JSONArray) entity.get("data");
        Type listOfClassObject = TypeToken.getParameterized(ArrayList.class, obj.getClass()).getType();
        Gson gson = new Gson();
        ArrayList<T> one = gson.fromJson(data.toString(), listOfClassObject);
        int index = -1;
        for (int i = 0; i < one.size(); i++) {
            if (one.get(i).getId() == obj.getId()) {
                index = i;
            }
        }
        one.remove(index);
        one.add(obj);
        entity.put("data", one);
        try (Writer writer = new FileWriter("/home/ig2i/IdeaProjects/try/src/main/resources/E_Symptome.json")) {
            gson.toJson(entity, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<T> findAll(Class<T> entityClass) {
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader("/home/ig2i/IdeaProjects/try/src/main/resources/E_Symptome.json")) {
            JSONObject entity = (JSONObject) parser.parse(reader);
            JSONArray data = (JSONArray) entity.get("data");
            Type listOfClassObject = new TypeToken<ArrayList<T>>() {
            }.getType();
            Gson gson = new Gson();
            return gson.fromJson(data.toString(), listOfClassObject);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteAll(Class<T> entityClass) {
        try (Writer writer = new FileWriter("/home/ig2i/IdeaProjects/try/src/main/resources/E_Symptome.json")) {
            writer.write("{}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
