package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CompasModel implements Serializable{

    private static final CompasModel instance = new CompasModel();

    private final Map<String, String[]> model;

    public CompasModel() {
        model = new HashMap<String, String[]>();

    }

    public static CompasModel getInstance() {
        return instance;
    }

    public void add(String[] s, String id) {
        model.put(id, s);
    }

    public String[] getFromList(String id){
        return model.get(id);
    }


    public void delCompas(String id) {
        model.remove(id);
    }

    public Map<String, String[]> getAll(){
        return model;
    }

    public String getType(int i) {
        String side = null;
        for (String key: model.keySet()) {
            String[] s= model.get(key);
            int a=Integer.parseInt(s[0]);
            int b=Integer.parseInt(s[1]);
            if (i>=a && i<=b)
                side=key;
        }
        return side;
    }

}