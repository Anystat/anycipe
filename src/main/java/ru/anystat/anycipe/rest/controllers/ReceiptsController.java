package ru.anystat.anycipe.rest.controllers;

import org.bson.Document;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.anystat.anycipe.rest.repositories.ReceiptsRepository;

/**
 * Created by ustits on 09.11.16.
 */
@RestController
@RequestMapping("/receipts")
public class ReceiptsController extends AbstractController<ReceiptsRepository> {

    @RequestMapping(value = "/ingredients", method = RequestMethod.GET)
    public Iterable<Document> getEntriesByMultipleParams(@RequestParam String[] ingredients) {
        return getRepository().findByMultipleParams(ingredients);
    }
}
