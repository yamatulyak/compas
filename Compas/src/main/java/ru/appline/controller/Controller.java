package ru.appline.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ru.appline.logic.CompasModel;


@RestController
public class Controller {
    private static final CompasModel compasmodel = CompasModel.getInstance();

    @PostMapping(value = "/enter", consumes = "application/json")
    public void enter(@RequestBody Map<String,String> map) {
        String[] deg;
        for (String key: map.keySet()){
            deg = map.get(key).split("-");
            compasmodel.add(deg, key);
        }
    }

    @GetMapping(value = "/get", consumes = "application/json", produces = "application/json")
    public Map<String,String> get(@RequestBody Map<String,Integer> map ){
        Map<String, String> map_new = new HashMap<String, String>();
        map_new.put("Side", compasmodel.getType(map.get("Degree")));
        return map_new;
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public Map<String, String[]> getAll(){
        return  compasmodel.getAll();
    }

}