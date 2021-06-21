package delivery.deliverybe.error_to_return;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ApiError {

    private Long timeStamp = new Date().getTime();
    private String message;
    private Integer statusCode;
    private String url;
    Map<String, String> validationErrors;

    public ApiError(String message, Integer statusCode, String url) {
        this.message = message;
        this.statusCode = statusCode;
        this.url = url;
        this.validationErrors = new HashMap<>();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(Map<String, String> validationErrors) {
        this.validationErrors = validationErrors;
    }
}
