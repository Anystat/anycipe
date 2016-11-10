package ru.anystat.anycipe.rest.controllers;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.anystat.anycipe.rest.RestContext;
import ru.anystat.anycipe.rest.repositories.ReceiptsRepository;

/**
 * Created by ustits on 09.11.16.
 */
@RestController
@RequestMapping("/receipts")
public class ReceiptsController {

    @Autowired
    private ReceiptsRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Document> getEntities() {
        return repository.getAll();
    }
}
