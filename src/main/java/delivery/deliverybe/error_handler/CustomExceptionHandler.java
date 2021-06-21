package delivery.deliverybe.error_handler;

import delivery.deliverybe.error_to_return.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request
    ) {
        ApiError apiError = new ApiError("Validation Error", 400, request.getContextPath());
        BindingResult result = ex.getBindingResult();
        Map<String, String> validationErrors = new HashMap<>();
        for (FieldError error: result.getFieldErrors()){
            validationErrors.put(error.getField(), error.getDefaultMessage());
        }
        apiError.setValidationErrors(validationErrors);
        return handleExceptionInternal(ex, apiError, headers, HttpStatus.BAD_REQUEST, request);
    }
}
