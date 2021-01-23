package com.galvanize.guestbook.service;

import com.galvanize.guestbook.model.GuestEntry;
import com.galvanize.guestbook.repository.GuestBookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GuestBookServiceImpl {

    private GuestBookRepository guestBookRepository;

    private List<GuestEntry> guestEntries = new ArrayList<>();

    public GuestBookServiceImpl(GuestBookRepository guestBookRepository) {
        this.guestBookRepository = guestBookRepository;
    }


    public List<GuestEntry> getAllGuestEntries(){
//        List<GuestEntry> guestEntries = Arrays.asList(new GuestEntry("Steve","GoodTrip")
//                ,new GuestEntry("Smith","Avg"));
        return guestBookRepository.findAll();
    }
}
