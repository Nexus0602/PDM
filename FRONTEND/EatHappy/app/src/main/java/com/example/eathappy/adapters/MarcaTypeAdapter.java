package com.example.eathappy.adapters;

import com.example.eathappy.dao.Categoria;
import com.example.eathappy.dao.CategoriaImpl;
import com.example.eathappy.dao.Marca;
import com.example.eathappy.dao.MarcaImpl;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class MarcaTypeAdapter implements JsonSerializer<Marca>, JsonDeserializer<Marca> {
    @Override
    public Marca deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        String nombre  = jsonObject.get("nombre").getAsString();
        String direccion  = jsonObject.get("direccion").getAsString();
        Integer telefono  = jsonObject.get("telefono").getAsInt();
        String cif  = jsonObject.get("cif").getAsString();
        return new MarcaImpl(nombre,direccion,telefono,cif);


    }

    @Override
    public JsonElement serialize(Marca src, Type typeOfSrc, JsonSerializationContext context) {

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("nombre", src.getNombre());
        jsonObject.addProperty("direccion", src.getDireccion());
        jsonObject.addProperty("telefono", src.getTelefono().toString());
        jsonObject.addProperty("cif", src.getCif());

        return jsonObject;
    }
}
