package com.galvanize.guestbook.controller;

import com.galvanize.guestbook.model.GuestEntry;
import com.galvanize.guestbook.service.GuestBookServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class GuestBookController {

    private List<GuestEntry> guestEntries = new ArrayList<>();

    private GuestBookServiceImpl guestBookService;

    public GuestBookController(GuestBookServiceImpl guestBookService) {
        this.guestBookService = guestBookService;
    }

    @PostMapping("/guests")
    public GuestEntry createGuestEntry(@RequestBody GuestEntry guestEntry){
        guestEntries.add(guestEntry);
        return guestEntries.contains(guestEntry) ? guestEntry : null;
    }
    
    @GetMapping("/guests")
    public List<GuestEntry> getAllGuestEntries(){
       return guestBookService.getAllGuestEntries();
    }
    

}
