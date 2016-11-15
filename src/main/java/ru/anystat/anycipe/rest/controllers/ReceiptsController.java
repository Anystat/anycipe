package ru.anystat.anycipe.rest.controllers;

import org.bson.Document;
import org.springframework.web.bind.annotation.*;
import ru.anystat.anycipe.rest.repositories.ReceiptsRepository;

import java.util.Map;

/**
 * Created by ustits on 09.11.16.
 */
@RestController
@RequestMapping("/receipts")
public class ReceiptsController extends AbstractController<ReceiptsRepository> {

    @RequestMapping(value = "/{name}/ingredients", method = RequestMethod.GET)
    public Iterable<Document> getEntriesByMultipleParams(@PathVariable String name,
                                                         @RequestParam Map<String, String> requestParams) {
        return null;
    }

}
