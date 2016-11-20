package ru.anystat.anycipe.rest.controllers;

import org.bson.Document;
import org.springframework.web.bind.annotation.*;
import ru.anystat.anycipe.rest.repositories.ReceiptsRepository;

import java.util.Arrays;

/**
 * Created by ustits on 09.11.16.
 */
@RestController
@RequestMapping("/receipts")
public class ReceiptsController extends AbstractController<ReceiptsRepository> {

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public Iterable<Document> getEntriesByMultipleParams(@RequestParam(value = "ingredient[]") String[] ingredients) {
        return getRepository().findByMultipleParams(ingredients);
    }
}
