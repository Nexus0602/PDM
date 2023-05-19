package com.example.eathappy.adapters;

import com.example.eathappy.dao.Alergeno;
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

public class UsuarioTypeAdapter implements JsonSerializer<Usuario>, JsonDeserializer<Usuario>{

    @Override
    public Usuario deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        int id  = jsonObject.get("id").getAsInt();
        String nombre  = jsonObject.get("nombre").getAsString();
        String apellidos  = jsonObject.get("apellidos").getAsString();
        String email  = jsonObject.get("email").getAsString();
        String contrasenya  = jsonObject.get("contrasenya").getAsString();

        List<Alergeno.tipoAlergeno> alergenos = context.deserialize(jsonObject.get("alergenos"), new TypeToken<List<Alergeno.tipoAlergeno>>() {}.getType());
        //List<Producto> favoritos = context.deserialize(jsonObject.get("favoritos"), new TypeToken<List<ProductoImpl>>() {}.getType());

        /*JsonElement favoritosElement = jsonObject.get("favoritos");
        List<Producto> favoritos = null;
        if (favoritosElement != null && favoritosElement.isJsonArray()) {
            JsonArray favoritosArray = favoritosElement.getAsJsonArray();
            favoritos = new LinkedList<>();
            for (JsonElement favoritoElement : favoritosArray) {
                JsonObject favoritoObject = favoritoElement.getAsJsonObject();
                Producto favorito = context.deserialize(favoritoObject, Producto.class); // Utilizar ProductoTypeAdapter
                favoritos.add(favorito);
            }
        }*/

        // Implementar MarcaTypeAdapter , CategoriaTypeAdapter e IngredienteTypeAdapter
        return new UsuarioImpl(id,nombre,apellidos,email,contrasenya, alergenos);


    }

    @Override
    public JsonElement serialize(Usuario src, Type typeOfSrc, JsonSerializationContext context) {

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", src.getId().toString());
        jsonObject.addProperty("nombre", src.getNombre());
        jsonObject.addProperty("apellidos", src.getApellidos());
        jsonObject.addProperty("email", src.getEmail());
        jsonObject.addProperty("contrasenya", src.getContrasenya());

        JsonArray alergenosArray = context.serialize(src.getAlergenos()).getAsJsonArray();
        jsonObject.add("alergenos", alergenosArray);

        /*JsonArray favoritosArray = new JsonArray();
        if (src.getFavoritos() != null) {
            for (Producto favorito : src.getFavoritos()) {
                JsonElement favoritoElement = context.serialize(favorito, Producto.class); // Utilizar ProductoTypeAdapter
                favoritosArray.add(favoritoElement);
            }
        }
        jsonObject.add("favoritos", favoritosArray);*/

        return jsonObject;
    }
}
