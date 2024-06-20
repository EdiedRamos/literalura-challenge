package com.literalura.challenge.deserialization;

import com.google.gson.*;
import com.literalura.challenge.dto.BookData;

import java.lang.reflect.Type;

public class BookDeserializer implements JsonDeserializer<BookData> {
    @Override
    public BookData deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        BookData book = new BookData();

        JsonArray results = jsonObject.getAsJsonArray("results");

        if (results.isEmpty()) {
            throw new RuntimeException(new Exception("Libro no encontrado"));
        }

        JsonObject firstBook = results.get(0).getAsJsonObject();

//        Automatically deserialization
        Gson gson = new Gson();
        book = gson.fromJson(firstBook, BookData.class);

//        Deserialize author name
        JsonArray authors = firstBook.getAsJsonArray("authors");
        if (!authors.isEmpty()) {
            JsonObject firstAuthor = authors.get(0).getAsJsonObject();
            String authorName = firstAuthor.get("name").getAsString();
            book.setAuthor(authorName);
        }

//        Deserialize language
        JsonArray languages = firstBook.getAsJsonArray("languages");
        if (!languages.isEmpty()) {
            String firstLanguage = languages.get(0).getAsString();
            book.setLanguage(firstLanguage);
        }

        return book;
    }
}
