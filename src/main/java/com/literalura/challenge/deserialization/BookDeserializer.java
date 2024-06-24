package com.literalura.challenge.deserialization;

import com.google.gson.*;
import com.literalura.challenge.dto.BookDTO;

import java.lang.reflect.Type;

public class BookDeserializer implements JsonDeserializer<BookDTO> {
    @Override
    public BookDTO deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        BookDTO book = new BookDTO();

        JsonArray results = jsonObject.getAsJsonArray("results");

        if (results.isEmpty()) {
            throw new RuntimeException(new Exception("Libro no encontrado"));
        }

        JsonObject firstBook = results.get(0).getAsJsonObject();

//        Automatically deserialization
        Gson gson = new Gson();
        book = gson.fromJson(firstBook, BookDTO.class);

//        Deserialize language
        JsonArray languages = firstBook.getAsJsonArray("languages");
        if (!languages.isEmpty()) {
            String firstLanguage = languages.get(0).getAsString();
            book.setLanguage(firstLanguage);
        }

        return book;
    }
}
