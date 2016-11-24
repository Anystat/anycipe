package ru.anystat.anycipe.rest.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Created by ustits on 23.11.16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AbstractControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReceiptsController receiptsController;

    @MockBean
    private IngredientsController ingredientsController;

    @Test
    public void testGetOkOnGetAll() throws Exception {
        mockMvc.perform(get("/receipts")).andExpect(status().isOk());
        mockMvc.perform(get("/ingredients")).andExpect(status().isOk());
    }

   @Test
    public void testNotFoundOnGetAll() throws Exception {
       mockMvc.perform(get("/wrong")).andExpect(status().isNotFound());
    }
}