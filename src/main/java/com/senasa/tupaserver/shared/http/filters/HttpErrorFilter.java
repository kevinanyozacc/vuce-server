package com.senasa.tupaserver.shared.http.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.senasa.tupaserver.shared.http.domain.ErrorFieldEntity;
import com.senasa.tupaserver.shared.http.domain.ErrorHttpEntity;
import com.senasa.tupaserver.shared.http.domain.ErrorNotFoundException;
import com.senasa.tupaserver.shared.http.domain.ErrorValidateException;

@ControllerAdvice
public class HttpErrorFilter {
  @ExceptionHandler(Throwable.class)
  public ResponseEntity<Object> handle(Exception ex,
      HttpServletRequest request, HttpServletResponse response) {
    ErrorHttpEntity error = new ErrorHttpEntity();
    error.message = ex.getMessage();
    error.status = 501;
    error.success = false;
    error.statusCode = ex.getClass().getName();
    ex.printStackTrace();
    // handle exception
    if (ex instanceof NullPointerException) {
      error.status = 400;
    } else if (ex instanceof ErrorNotFoundException) {
      error.status = ((ErrorNotFoundException) ex).getStatus();
      error.statusCode = ((ErrorNotFoundException) ex).getStatusCode();
    } else if (ex instanceof MethodArgumentNotValidException) {
      ((MethodArgumentNotValidException) ex).getFieldErrors().forEach(item -> {
        error.status = 402;
        error.message = "Los datos son incorrectos";
        error.errors.add(new ErrorFieldEntity(item));
      });
    } else if (ex instanceof ErrorValidateException) {
      error.status = 402;
      error.message = "Los datos son incorrectos";
      error.errors.add(((ErrorValidateException) ex).getErrorField());
    }
    // response
    return ResponseEntity.status(error.status).body(error);
  }
}
