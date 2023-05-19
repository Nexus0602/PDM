package com.example.eathappy.adapters;

import com.example.eathappy.dao.Categoria;
import com.example.eathappy.dao.CategoriaImpl;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;


public class CategoriaTypeAdapter implements JsonSerializer<Categoria>, JsonDeserializer<Categoria>{

    @Override
    public Categoria deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        String nombre  = jsonObject.get("nombre").getAsString();
        String descripcion  = jsonObject.get("descripcion").getAsString();
        return new CategoriaImpl(nombre,descripcion);


    }

    @Override
    public JsonElement serialize(Categoria src, Type typeOfSrc, JsonSerializationContext context) {

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("nombre", src.getNombre());
        jsonObject.addProperty("descripcion", src.getDescripcion());

        return jsonObject;
    }
}

