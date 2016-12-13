package ru.anystat.anycipe.rest.controllers;

import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.anystat.anycipe.rest.repositories.Repository;

/**
 * Created by ustits on 13.11.16.
 */
public abstract class AbstractController<T extends Repository> {

    private final static Integer ENTITIES_PER_PAGE = 10;

    @Autowired
    private T repository;

    @RequestMapping(method = RequestMethod.GET)
    public FindIterable<Document> getEntities() {
        return repository.findAll();
    }

    @RequestMapping(value = "/page/{page}", method = RequestMethod.GET)
    public FindIterable<Document> getEntitiesByPages(@PathVariable Integer page, @RequestParam Integer size) throws Exception {
        if (size == null) {
            size = ENTITIES_PER_PAGE;
        }
        FindIterable<Document> result = repository.findAll().skip(size * page).limit(size);
        if (result.first() == null) {
            throw new NoMorePagesException();
        }
        return result;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public FindIterable<Document> getEntriesByName(@PathVariable String name) {
        return repository.findByName(name);
    }

    @RequestMapping(value = "/find/{symbol}", method = RequestMethod.GET)
    public FindIterable<Document> getEntriesRegex(@PathVariable String symbol) {
        return getRepository().findByPattern(symbol);
    }

    protected T getRepository() {
        return repository;
    }

    @ExceptionHandler(NoMorePagesException.class)
    public ResponseEntity<Document> handleNoMorePagesException() {
        return new ResponseEntity<>(new Document("error", "no more pages to show"), HttpStatus.BAD_REQUEST);
    }
}
