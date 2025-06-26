package com.example;

public class MyService {
    private final ExternalApi externalApiProvider;

    public MyService(ExternalApi externalApiProvider) {
        this.externalApiProvider = externalApiProvider;
    }

    public String fetchData() {
        return externalApiProvider.retrieveInformation();
    }
}
