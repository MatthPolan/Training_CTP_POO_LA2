package w.JsonDao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import w.dao.Dao;


import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public abstract class JsonDao<T> implements Dao<T> {
    @Override
    public Optional<T> find(Class<T> entityClass, int id) {
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader("/home/ig2i/IdeaProjects/try/src/main/resources/E_Symptome.json")) {
            JSONObject entity = (JSONObject) parser.parse(reader);
            JSONArray data = (JSONArray) entity.get("data");
            Iterator<JSONObject> iterator = data.iterator();

            Type listOfClassObject = new TypeToken<ArrayList<T>>() {
            }.getType(); //magie
            Gson gson = new Gson();
            List<T> one = gson.fromJson(data.toString(), listOfClassObject);
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
    public void create(T obj) {
        JSONParser parser = new JSONParser();
        JSONObject entity = null;
        try (Reader reader = new FileReader("/home/ig2i/IdeaProjects/try/src/main/resources/E_Symptome.json")) {
            entity = (JSONObject) parser.parse(reader);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONArray data = (JSONArray) entity.get("data");
        Type listOfClassObject = new TypeToken<ArrayList<T>>() {
        }.getType(); //magie
        Gson gson = new Gson();
        List<T> one = gson.fromJson(data.toString(), listOfClassObject);
        one.add(obj);
        entity.put("data", one);
        try (Writer writer = new FileWriter("/home/ig2i/IdeaProjects/try/src/main/resources/E_Symptome.json")) {
            gson.toJson(entity, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(T obj) {

    }

    @Override
    public void update(T obj) {

    }

    @Override
    public List<T> findAll(Class<T> entityClass) {
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader("/home/ig2i/IdeaProjects/try/src/main/resources/E_Symptome.json")) {
            JSONObject entity = (JSONObject) parser.parse(reader);
            JSONArray data = (JSONArray) entity.get("data");
            System.out.println(data);
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

    }
}
