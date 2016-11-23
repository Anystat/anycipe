package ru.anystat.anycipe.rest.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Created by ustits on 23.11.16.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ReceiptsController.class)
public class ReceiptsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReceiptsController controller;

    @Test
    public void testGetOkOnGetAll() throws Exception {
        mockMvc.perform(get("/receipts").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk());
    }

   @Test
    public void testNotFoundOnGetAll() throws Exception {
       mockMvc.perform(get("/wrong").accept(MediaType.TEXT_PLAIN))
               .andExpect(status().isNotFound());
    }
}