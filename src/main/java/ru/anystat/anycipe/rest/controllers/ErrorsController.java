package ru.anystat.anycipe.rest.controllers;

import org.springframework.boot.autoconfigure.web.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.anystat.anycipe.rest.utils.JsonUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ustits on 20.11.16.
 */
@RestController
@RequestMapping(value = "/error")
public class ErrorsController extends AbstractErrorController {

    public ErrorsController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @RequestMapping
    public ResponseEntity customError(HttpServletRequest request) {
        HttpStatus status = getStatus(request);
        return JsonUtils.getErrorEntity(status.value(), status.getReasonPhrase(), status);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
