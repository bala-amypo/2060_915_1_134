package com.example.demo.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String msg) { super(msg); }
}


java
// src/main/java/com/example/demo/exception/ValidationException.java
package com.example.demo.exception;

public class ValidationException extends RuntimeException {
    public ValidationException(String msg) { super(msg); }
}

