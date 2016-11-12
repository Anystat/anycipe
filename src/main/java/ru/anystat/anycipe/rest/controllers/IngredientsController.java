package ru.anystat.anycipe.rest.controllers;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.anystat.anycipe.rest.repositories.IngredientsRepository;
import ru.anystat.anycipe.rest.repositories.ReceiptsRepository;

/**
 * Created by ustits on 12.11.16.
 */
@RestController
@RequestMapping("/ingredients")
public class IngredientsController {

    @Autowired
    private IngredientsRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Document> getEntities() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Iterable<Document> getEntriesByName(@PathVariable String name) {
        return repository.findByName(name);
    }
}
