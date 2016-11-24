package ru.anystat.anycipe.rest.controllers;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.anystat.anycipe.rest.utils.JsonUtils;

/**
 * Created by ustits on 20.11.16.
 */
@RestController
@RequestMapping(value = "/error")
public class ErrorsController implements ErrorController {

    @RequestMapping
    public ResponseEntity handleConflict() {
        return JsonUtils.getErrorEntity(404, "Nothing to show you", HttpStatus.NOT_FOUND);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
