package com.galvanize.guestbook.exception;

import com.galvanize.guestbook.model.GuestBoolError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * APIExceptionHandler global application exception handler
 */
@ControllerAdvice
public class APIExceptionHandler  {

    @ExceptionHandler(APIException.class)
    public ResponseEntity<Object> handleAppException(APIException apiException){
        //APIException newApiException = new APIException(apiException.getErrCode(),apiException.getErrMsg());
        GuestBoolError guestBoolError = new GuestBoolError(apiException.getErrCode(),apiException.getErrMsg());
        return new ResponseEntity<>(guestBoolError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
