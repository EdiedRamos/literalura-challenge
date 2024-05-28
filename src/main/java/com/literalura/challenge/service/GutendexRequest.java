package com.literalura.challenge.service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class GutendexRequest {
    private static final String baseApi = "https://gutendex.com/books/";

    private static String encodeText(String text) {
        return URLEncoder.encode(text, StandardCharsets.UTF_8);
    }

    public static String searchByTitle(String title) {
        return APIConsumer.makeRequest(baseApi.concat(String.format("?search=%s", encodeText(title))));
    }

}
