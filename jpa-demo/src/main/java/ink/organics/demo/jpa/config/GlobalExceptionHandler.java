package ink.organics.demo.jpa.config;

import ink.organics.demo.jpa.exception.OperationException;
import ink.organics.demo.jpa.exception.UnauthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    /**
     * 身份验证异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<String> unauthorizedException(UnauthorizedException e) {
        log.warn("UnauthorizedException code : [{}] , message : {}", HttpStatus.UNAUTHORIZED.value(), e.getMessage());

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(e.getMessage());
    }

    /**
     * 业务异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(OperationException.class)
    public ResponseEntity<String> operationException(OperationException e) {
        log.warn("OperationException code : [{}] , message : {}", HttpStatus.FORBIDDEN.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {

        String message = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(e -> e.getField() + ": " + e.getDefaultMessage())
                .reduce((a, b) -> a + ";" + b)
                .orElse("未知的参数异常");

        return this.handleExceptionInternal(ex, message, headers, status, request);
    }
}
