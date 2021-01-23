package com.galvanize.guestbook.it;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.guestbook.model.GuestEntry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GuestBookControllerTest {

    @Autowired
    private MockMvc mockmvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void createGuestEntryTest() throws Exception {

        GuestEntry ge =  new GuestEntry("abc","how are you?");

        mockmvc.perform(post("/guests")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(ge)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("abc"));

    }

}
