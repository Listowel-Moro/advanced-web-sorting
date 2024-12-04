package listo.util;

import org.springframework.hateoas.Link;
import java.util.List;

public class ApiResponse<T> {
    private int statusCode;
    private String message;
    private T data;
    private List<Link> links;

    // Constructor
    public ApiResponse(int statusCode, String message, T data, List<Link> links) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
        this.links = links;
    }

    // Getters and Setters
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
