package com.example;

public class MyService {
    private final ExternalApi externalDataProvider;

    public MyService(ExternalApi externalDataProvider) {
        this.externalDataProvider = externalDataProvider;
    }

    public String fetchData() {
        return externalDataProvider.retrieveInformation();
    }
}
