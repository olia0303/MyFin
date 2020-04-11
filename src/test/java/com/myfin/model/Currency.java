package com.myfin.model;

public enum Currency {
    USD("USD"),
    EUR("EUR"),
    RUB("rub");

    private String name;

    public String getName() {
        return this.name;
    }

    Currency(String name) {
        this.name = name;
    }
}
