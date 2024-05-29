package com.literalura.challenge.deserialization;

import com.google.gson.*;
import com.literalura.challenge.dto.BookData;

import java.lang.reflect.Type;

public class BookDeserializer implements JsonDeserializer<BookData> {
    @Override
    public BookData deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        BookData book = new BookData();

//        Automatically deserialization
        Gson gson = new Gson();
        book = gson.fromJson(jsonElement, BookData.class);

//        Deserialize author name
        JsonArray authors = jsonObject.getAsJsonArray("authors");
        if (!authors.isEmpty()) {
            JsonObject firstAuthor = authors.get(0).getAsJsonObject();
            String authorName = firstAuthor.get("name").getAsString();
            book.setAuthor(authorName);
        }

//        Deserialize language
        JsonArray languages = jsonObject.getAsJsonArray("languages");
        if (!languages.isEmpty()) {
            String firstLanguage = languages.get(0).getAsString();
            book.setLanguage(firstLanguage);
        }

        return book;
    }
}
