package ru.anystat.anycipe.rest.controllers;

import org.bson.Document;
import org.springframework.web.bind.annotation.*;
import ru.anystat.anycipe.rest.model.Receipt;
import ru.anystat.anycipe.rest.repositories.ReceiptsRepository;

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

    @RequestMapping(value = "/find")
    public Iterable<Document> getEntriesByMultipleParamsInBody(@RequestBody Receipt receipt) {
        return getRepository().findByMultipleParams(receipt.getIngredients());
    }
}
