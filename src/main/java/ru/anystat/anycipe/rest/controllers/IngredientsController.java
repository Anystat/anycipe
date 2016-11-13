package ru.anystat.anycipe.rest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.anystat.anycipe.rest.repositories.IngredientsRepository;

/**
 * Created by ustits on 12.11.16.
 */
@RestController
@RequestMapping("/ingredients")
public class IngredientsController extends AbstractController<IngredientsRepository> {

}
