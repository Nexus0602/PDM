package com.example.eathappy.adapters;

import com.example.eathappy.dao.Alergeno;
import com.example.eathappy.dao.Categoria;
import com.example.eathappy.dao.CategoriaImpl;
import com.example.eathappy.dao.Ingrediente;
import com.example.eathappy.dao.IngredienteImpl;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class IngredienteTypeAdapter implements JsonSerializer<Ingrediente>, JsonDeserializer<Ingrediente> {

    @Override
    public Ingrediente deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        String nombre  = jsonObject.get("nombre").getAsString();
        String descripcion  = jsonObject.get("descripcion").getAsString();
        List<Alergeno.tipoAlergeno> alergenos = context.deserialize(jsonObject.get("alergenos"), new TypeToken<List<Alergeno.tipoAlergeno>>() {}.getType());
        String id  = jsonObject.get("id").getAsString();
        return new IngredienteImpl(alergenos,nombre,descripcion,id);


    }

    @Override
    public JsonElement serialize(Ingrediente src, Type typeOfSrc, JsonSerializationContext context) {

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("nombre", src.getNombre());
        jsonObject.addProperty("descripcion", src.getDescripcion());
        jsonObject.addProperty("id", src.getId());
        JsonArray alergenosArray = context.serialize(src.getAlergenos()).getAsJsonArray();
        jsonObject.add("alergenos", alergenosArray);
        return jsonObject;
    }
}

