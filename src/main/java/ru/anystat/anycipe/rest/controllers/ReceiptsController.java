package ru.anystat.anycipe.rest.controllers;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.anystat.anycipe.rest.RestContext;

/**
 * Created by ustits on 09.11.16.
 */
@RestController
@RequestMapping("/receipts")
public class ReceiptsController {

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Document> getEntities() {
        return RestContext.getInstance().getDB().getCollection("restaurants").find();
    }
}
