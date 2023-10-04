package ru.f3n1b00t.contractservice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.f3n1b00t.contractservice.dto.response.ContractInteractionErrorResponse;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ContractInteractionErrorResponse handleValidationException(MethodArgumentNotValidException ex) {
        log.error("Json parse exception occurred!", ex);
        return ContractInteractionErrorResponse.builder()
                .isOk(false)
                .message(ex.getFieldError().getDefaultMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ContractInteractionErrorResponse handleMessageNotReadableException(HttpMessageNotReadableException ex) {
        log.error("An exception occurred!", ex);
        return ContractInteractionErrorResponse.builder()
                .isOk(false)
                .message("JSON parse error")
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConversionFailedException.class)
    public ContractInteractionErrorResponse handleConversionFailedException(ConversionFailedException ex) {
        log.error("An exception occurred!", ex);
        return ContractInteractionErrorResponse.builder()
                .isOk(false)
                .message("JSON parse error")
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ContractInteractionErrorResponse handleException(Exception ex) {
        log.error("An exception occurred!", ex);
        return ContractInteractionErrorResponse.builder()
                .isOk(false)
                .message("Something went wrong!")
                .build();
    }
}
