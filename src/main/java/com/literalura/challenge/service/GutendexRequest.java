package com.literalura.challenge.service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class GutendexRequest {
    private final String baseApi = "https://gutendex.com/books/";

    private String encodeText(String text) {
        return URLEncoder.encode(text, StandardCharsets.UTF_8);
    }

    public String searchByTitle(String title) {
        return APIConsumer.makeRequest(baseApi.concat(String.format("?search=%s", encodeText(title))));
    }

}
