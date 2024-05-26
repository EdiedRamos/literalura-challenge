package com.literalura.challenge.service;

import com.google.gson.Gson;

public class JSONConverter {
    public <T> T toObject(String json, Class<T> classConverter) {
        Gson gson = new Gson();
        return gson.fromJson(json, classConverter);
    }
}
