package com.myfin.api;

import com.myfin.model.Rates;

public class RatesAdapter extends APIAdapter {
    public static final String NB_RB_API_URL = "https://www.nbrb.by/api/exrates/rates/%s";

    public Rates get(String id) {
        return gson.fromJson(apiUtils.getRequest(String.format(NB_RB_API_URL, id)).asString().trim(), Rates.class);
    }
}
