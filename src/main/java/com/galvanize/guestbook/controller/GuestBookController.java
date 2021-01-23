package com.galvanize.guestbook.controller;

import com.galvanize.guestbook.exception.APIException;
import com.galvanize.guestbook.model.GuestEntry;
import com.galvanize.guestbook.service.GuestBookServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class GuestBookController {

    private GuestBookServiceImpl guestBookService;

    public GuestBookController(GuestBookServiceImpl guestBookService) {
        this.guestBookService = guestBookService;
    }

    @PostMapping("/guests")
    public GuestEntry createGuestEntry(@RequestBody GuestEntry guestEntry) throws APIException {
        return guestBookService.createGuestEntry(guestEntry);
    }
    
    @GetMapping("/guests")
    public List<GuestEntry> getAllGuestEntries(){
       return guestBookService.getAllGuestEntries();
    }
    

}
