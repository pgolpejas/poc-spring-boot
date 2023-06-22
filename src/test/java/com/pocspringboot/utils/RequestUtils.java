package com.pocspringboot.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Collections;

public class RequestUtils {

    private RequestUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static <T> HttpEntity<T> buildRequest(HttpHeaders headers, T entity) throws Exception {
        headers = (headers != null ? headers : new HttpHeaders());
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<T> request = new HttpEntity<>(entity, headers);
        return request;
    }

}
