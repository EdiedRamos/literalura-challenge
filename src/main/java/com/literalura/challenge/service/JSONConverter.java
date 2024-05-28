package com.literalura.challenge.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONConverter {
    public <T> T toObject(String json, Class<T> classConverter) {
        Gson gson = new Gson();
        return gson.fromJson(json, classConverter);
    }

    public <T, U> T toObjectWithBuilder(String json, Class<T> classConverter, U classDeserializer) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(classConverter, classDeserializer);
        Gson gson = gsonBuilder.create();
        return gson.fromJson(json, classConverter);
    }
}
