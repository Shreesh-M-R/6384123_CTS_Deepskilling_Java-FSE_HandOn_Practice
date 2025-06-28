package com.mycompany.mockito;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lavan
 */
public class MyServiceExceptionTest {

    @Test
    void testVoidMethodThrowsException() {
        ExternalApi mockApi = mock(ExternalApi.class);
        doThrow(new RuntimeException("Action failed")).when(mockApi).performAction();

        MyService service = new MyService(mockApi);

        RuntimeException exception = assertThrows(RuntimeException.class, service::doAction);
        assertEquals("Action failed", exception.getMessage());
    }
}