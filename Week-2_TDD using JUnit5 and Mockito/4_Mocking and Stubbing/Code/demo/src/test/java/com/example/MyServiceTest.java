package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class MyServiceTest {

    private MyService serviceUnderTest;
    private ExternalApi mockedExternalApi;

    @BeforeEach
    void setUp() {
        mockedExternalApi = mock(ExternalApi.class);
        serviceUnderTest = new MyService(mockedExternalApi);
    }

    @Test
    public void testExternalApi() {
        when(mockedExternalApi.retrieveInformation()).thenReturn("Mock Data");

        String actualResult = serviceUnderTest.fetchData();

        assertEquals("Mock Data", actualResult);
        verify(mockedExternalApi, times(1)).retrieveInformation();
    }
}
