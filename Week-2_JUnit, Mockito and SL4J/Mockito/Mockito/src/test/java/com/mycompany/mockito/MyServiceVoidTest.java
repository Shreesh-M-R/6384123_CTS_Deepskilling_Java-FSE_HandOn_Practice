package com.mycompany.mockito;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

/**
 *
 * @author lavan
 */
public class MyServiceVoidTest {

    @Test
    void testVoidMethod() {
        ExternalApi mockApi = mock(ExternalApi.class);
        doNothing().when(mockApi).performAction();

        MyService service = new MyService(mockApi);
        service.doAction();

        verify(mockApi).performAction();
    }
}