package com.literalura.challenge.deserialization;

import com.google.gson.*;
import com.literalura.challenge.dto.AuthorDTO;

import java.lang.reflect.Type;

public class AuthorDeserializer implements JsonDeserializer<AuthorDTO> {

    @Override
    public AuthorDTO deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        AuthorDTO authorDTO = new AuthorDTO();

        JsonArray results = jsonObject.getAsJsonArray("results");

        if (results.isEmpty()) {
            throw new RuntimeException(new Exception("Libro no encontrado"));
        }

        JsonObject firstBook = results.get(0).getAsJsonObject();

        JsonArray authors = firstBook.getAsJsonArray("authors");

        if (authors.isEmpty()) {
            throw new RuntimeException(new Exception("Libro sin autor/es"));
        }

        JsonObject firstAuthor = authors.get(0).getAsJsonObject();

        Gson gson = new Gson();
        authorDTO = gson.fromJson(firstAuthor, AuthorDTO.class);

        return authorDTO;
    }
}
