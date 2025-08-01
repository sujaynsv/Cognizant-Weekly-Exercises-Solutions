package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class MyServiceTest {

    private ExternalApi mockExternalApi;
    private MyService serviceUnderTest;

    @BeforeEach
    void setUp() {
        mockExternalApi = mock(ExternalApi.class);
        serviceUnderTest = new MyService(mockExternalApi);
    }

    @Test
    public void testVerifyInteraction() {
        serviceUnderTest.fetchData();

        verify(mockExternalApi).retrieveInformation();
    }
}
