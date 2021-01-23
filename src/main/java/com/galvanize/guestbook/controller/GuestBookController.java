package com.galvanize.guestbook.controller;

import com.galvanize.guestbook.model.GuestEntry;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GuestBookController {

    private List<GuestEntry> guestEntries = new ArrayList<>();

    @PostMapping("/guests")
    public GuestEntry createGuestEntry(@RequestBody GuestEntry guestEntry){
        guestEntries.add(guestEntry);
        return guestEntries.contains(guestEntry) ? guestEntry : null;
    }

}
