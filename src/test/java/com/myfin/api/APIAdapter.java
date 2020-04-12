package com.myfin.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class APIAdapter {
        APIUtils apiUtils = new APIUtils();
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
}
