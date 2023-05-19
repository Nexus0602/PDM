package com.example.eathappy.adapters;

import com.example.eathappy.dao.Alergeno;
import com.example.eathappy.dao.Categoria;
import com.example.eathappy.dao.Ingrediente;
import com.example.eathappy.dao.Marca;
import com.example.eathappy.dao.Opinion;
import com.example.eathappy.dao.Producto;
import com.example.eathappy.dao.ProductoImpl;
import com.example.eathappy.dao.Usuario;
import com.example.eathappy.dao.UsuarioImpl;


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
import java.util.LinkedList;
import java.util.List;

public class ProductoTypeAdapter implements JsonSerializer<Producto>, JsonDeserializer<Producto>{
    @Override
    public Producto deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        int id  = jsonObject.get("id").getAsInt();
        String nombre  = jsonObject.get("nombre").getAsString();
        String codBarras  = jsonObject.get("codBarras").getAsString();
        List<Ingrediente> composicion = context.deserialize(jsonObject.get("composicion"), new TypeToken<List<Ingrediente>>() {}.getType());
        Marca marca = context.deserialize(jsonObject.get("marca"), new TypeToken<Marca>() {}.getType());
        List<Categoria> categorias = context.deserialize(jsonObject.get("categorias"), new TypeToken<List<Categoria>>() {}.getType());
        List<Opinion> historialOpiniones = context.deserialize(jsonObject.get("historialOpiniones"), new TypeToken<List<Opinion>>() {}.getType());

        return new ProductoImpl(nombre,marca,composicion,categorias,historialOpiniones,codBarras,id);
        //return new ProductoImpl(nombre,marca,composicion,categorias,codBarras,id);


    }

    @Override
    public JsonElement serialize(Producto src, Type typeOfSrc, JsonSerializationContext context) {

        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("id", src.getId().toString());
        jsonObject.addProperty("nombre", src.getNombre());
        jsonObject.addProperty("codBarras", src.getCodBarras());
        jsonObject.addProperty("marca", src.getMarca().getNombre().toString());
        JsonArray ingredientesArray = context.serialize(src.getComposicion()).getAsJsonArray();
        jsonObject.add("composicion", ingredientesArray);

        JsonArray categoriasArray = context.serialize(src.getCategorias()).getAsJsonArray();
        jsonObject.add("categorias", categoriasArray);

        JsonArray opinionessArray = context.serialize(src.getHistorialOpiniones()).getAsJsonArray();
        jsonObject.add("historialOpiniones", opinionessArray);
        return jsonObject;
    }
}
