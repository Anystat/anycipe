package ru.anystat.anycipe.rest.repositories;

import org.bson.Document;

/**
 * Created by ustits on 10.11.16.
 */
public interface Repository {

    Iterable<Document> getAll();
}
