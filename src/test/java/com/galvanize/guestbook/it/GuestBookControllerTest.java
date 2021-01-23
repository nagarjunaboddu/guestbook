package com.galvanize.guestbook.it;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.guestbook.model.GuestEntry;
import com.galvanize.guestbook.repository.GuestBookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class GuestBookControllerTest {

    @Autowired
    private MockMvc mockmvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private GuestBookRepository guestBookRepository;

    @Test
    public void createGuestEntryTest() throws Exception {

        GuestEntry ge =  new GuestEntry("abc","how are you?");

        mockmvc.perform(post("/guests")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(ge)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("abc"));

    }

    @Test
    void getAllGuestEntriesTest() throws Exception {

        List<GuestEntry> guestEntryList = Arrays.asList(new GuestEntry("Steve","GoodTrip")
                                                          ,new GuestEntry("Smith","Avg"));

        guestBookRepository.saveAll(guestEntryList);

        mockmvc.perform(get("/guests"))
                .andExpect(status().isOk())
        .andExpect(content().json(mapper.writeValueAsString(guestEntryList)));
    }

}
