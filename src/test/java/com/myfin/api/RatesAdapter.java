package com.myfin.api;

import com.myfin.model.Rate;

public class RatesAdapter extends APIAdapter {

    public Rate get(String id, String url) {
        return gson.fromJson(apiUtils.getRequest(String.format(url, id)).asString().trim(), Rate.class);
    }
}
