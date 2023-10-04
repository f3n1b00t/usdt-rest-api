package ru.f3n1b00t.contractservice.exception;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import ru.f3n1b00t.contractservice.dto.response.ContractInteractionErrorResponse;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GlobalExceptionHandlerTest {
    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @Test
    void testHandleValidationException_returnExpectedResult() {
        MethodArgumentNotValidException exception = mock(MethodArgumentNotValidException.class);
        FieldError fieldError = mock(FieldError.class);
        String message = "owner is invalid";

        when(exception.getFieldError()).thenReturn(fieldError);
        when(fieldError.getDefaultMessage()).thenReturn(message);

        ContractInteractionErrorResponse response = globalExceptionHandler.handleValidationException(exception);

        assertFalse(response.isOk());
        assertEquals(message, response.getMessage());
    }

    @Test
    void testHandleMessageNotReadableException_returnExpectedResult() {
        HttpMessageNotReadableException exception = mock(HttpMessageNotReadableException.class);

        ContractInteractionErrorResponse response = globalExceptionHandler.handleMessageNotReadableException(exception);

        assertFalse(response.isOk());
        assertEquals("JSON parse error", response.getMessage());
    }

    @Test
    void testHandleConversionFailedException_returnExpectedResult() {
        ConversionFailedException exception = mock(ConversionFailedException.class);

        ContractInteractionErrorResponse response = globalExceptionHandler.handleConversionFailedException(exception);

        assertFalse(response.isOk());
        assertEquals("JSON parse error", response.getMessage());
    }

    @Test
    void testHandleException_returnExpectedResult() {
        Exception exception = mock(Exception.class);

        ContractInteractionErrorResponse response = globalExceptionHandler.handleException(exception);

        assertFalse(response.isOk());
        assertEquals("Something went wrong!", response.getMessage());
    }
}