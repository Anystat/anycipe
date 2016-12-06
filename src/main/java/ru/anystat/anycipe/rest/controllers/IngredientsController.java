package ru.anystat.anycipe.rest.controllers;

import com.mongodb.client.FindIterable;
import org.bson.Document;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.anystat.anycipe.rest.model.Receipt;
import ru.anystat.anycipe.rest.repositories.IngredientsRepository;

/**
 * Created by ustits on 12.11.16.
 */
@RestController
@RequestMapping("/ingredients")
public class IngredientsController extends AbstractController<IngredientsRepository> {

    @RequestMapping(value = "/category/{name}")
    public FindIterable<Document> getEntriesByMultipleParamsInBody(@PathVariable String name) {
        return getRepository().findByCategory(name);
    }
}
