package ru.anystat.anycipe.rest.controllers;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.anystat.anycipe.rest.repositories.Repository;

/**
 * Created by ustits on 13.11.16.
 */
public abstract class AbstractController<T extends Repository> {

    @Autowired
    private T repository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Document> getEntities() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Iterable<Document> getEntriesByName(@PathVariable String name) {
        return repository.findByName(name);
    }

    protected T getRepository() {
        return repository;
    }
}
