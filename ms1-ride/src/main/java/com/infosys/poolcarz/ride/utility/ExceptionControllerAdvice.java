package com.infosys.poolcarz.ride.utility;

import com.infosys.poolcarz.ride.exception.ExceptionConstants;
import com.infosys.poolcarz.ride.exception.PoolcarzException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.MethodInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Locale;

@ControllerAdvice
public class ExceptionControllerAdvice {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PoolcarzException.class)
    @ResponseBody
    public ClientErrors exceptionHandler(PoolcarzException ex) {
        logger.info(ex.getMessage(), ex);
        ClientErrors errors;
        String errorCode = ex.getMessage();
        errors = new ClientErrors(errorCode, messageSource.getMessage(ex.getMessage(), null, Locale.ENGLISH));
        logger.debug("{}", errors);
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(JpaObjectRetrievalFailureException.class)
    @ResponseBody
    public ClientErrors exceptionHandler(JpaObjectRetrievalFailureException ex) {
        logger.info(ex.getMessage(), ex);
        String errorCode = ExceptionConstants.REQUESTED_OBJECT_NOT_FOUND.toString();
        ClientErrors errors = new ClientErrors(errorCode, messageSource.getMessage(errorCode, null, Locale.ENGLISH));
        logger.debug("{}", errors);
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseBody
    public ClientErrors handleBindingErrors(MissingServletRequestParameterException ex) {
        logger.info(ex.getMessage(), ex);
        String errorCode = ExceptionConstants.INPUT_PARAM_MISSING.toString();
        String message = ex.getParameterName() + " " + messageSource.getMessage(errorCode, null, Locale.ENGLISH);
        ClientErrors errors = new ClientErrors(errorCode, message);
        logger.debug("{}", errors);
        return errors;
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseBody
    public ClientErrors handleException(HttpMessageNotReadableException ex) {
        logger.info(ex.getMessage(), ex);
        String message;
        Throwable specificCause = ex.getMostSpecificCause();
        String errorCode = ExceptionConstants.MESSAGE_NOT_READABLE.toString();
        if (specificCause != null) {
            message = specificCause.getMessage();
        } else {
            message = messageSource.getMessage(errorCode, null, Locale.ENGLISH);
        }

        ClientErrors errors = new ClientErrors(errorCode, message);
        logger.debug("{}", errors);
        return errors;
    }


    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ClientErrors handleBindingErrors(MethodArgumentNotValidException ex) {
        String message;
        ClientErrors errors = new ClientErrors();
        BindingResult result = ex.getBindingResult();

        List<FieldError> fieldErrors = result.getFieldErrors();
        for (FieldError error : fieldErrors) {
            message = error.getDefaultMessage();
            errors.addError(error.getField(), message);
        }

        List<ObjectError> globalErrors = result.getGlobalErrors();
        for (ObjectError error : globalErrors) {
            message = error.getDefaultMessage();
            errors.addError(error.getObjectName(), message);
        }

        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    @ResponseBody
    public ClientErrors handleBindingErrors(HttpMediaTypeNotSupportedException ex) {
        logger.info(ex.getMessage(), ex);
        String errorCode = ExceptionConstants.MEDIA_TYPE_NOT_SUPPORTED.toString();
        String message = "Unsupported content type: " + ex.getContentType() + " " + "Supported content types " +
                ex.getSupportedMediaTypes();

        ClientErrors errors = new ClientErrors(errorCode, message);
        logger.debug("{}", errors);
        return errors;
    }

}
