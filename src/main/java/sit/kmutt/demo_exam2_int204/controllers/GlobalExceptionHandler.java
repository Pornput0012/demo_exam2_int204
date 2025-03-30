package sit.kmutt.demo_exam2_int204.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.method.ParameterValidationResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import sit.kmutt.demo_exam2_int204.exceptions.ErrorResponse;
import sit.kmutt.demo_exam2_int204.exceptions.ItemNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleItemNotFoundException(ItemNotFoundException ex, HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                request.getRequestURI());
        return errorResponse;
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
//    public ErrorResponse handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpServletRequest request) {
//        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(),
//                "Validation error. Check 'errors' field for details.",
//                request.getRequestURI());
//        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
//            errorResponse.addValidationError(fieldError.getField(), fieldError.getDefaultMessage());
//        }
//        return errorResponse;
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(
                err -> errors.put(err.getField(), err.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }


    @ExceptionHandler(HandlerMethodValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleHandlerMethodValidationException(HandlerMethodValidationException ex, HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                "Validation error. Check 'errors' field for details.",
                request.getRequestURI());

        List<ParameterValidationResult> paramNames = ex.getParameterValidationResults();

        for (ParameterValidationResult param : paramNames) {
            errorResponse.addValidationError(param.getMethodParameter().getParameterName(), param.getResolvableErrors().get(0).getDefaultMessage());
        }

        return errorResponse;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleAllUncaughtException(ItemNotFoundException ex, HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Unknown error occurred",
                request.getRequestURI());
        return errorResponse;
    }

    // ตัวสร้าง ErrorResponse
//    private ResponseEntity<ErrorResponse> buildErrorResponse(
//            Exception exception, HttpStatus httpStatus, WebRequest request) {
//        return buildErrorResponse(exception, exception.getMessage(), httpStatus, request);
//    }
//
//    private ResponseEntity<ErrorResponse> buildErrorResponse(
//            Exception exception, String message, HttpStatus httpStatus, WebRequest request) {
//
//        ErrorResponse errorResponse = new ErrorResponse(httpStatus.value(), message,
//                request.getDescription(false)
//        );
//        return ResponseEntity.status(httpStatus).body(errorResponse);
//    }

}
