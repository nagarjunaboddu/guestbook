package com.galvanize.guestbook.service;

import com.galvanize.guestbook.model.GuestEntry;
import com.galvanize.guestbook.repository.GuestBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestBookServiceImpl {

    private GuestBookRepository guestBookRepository;

    public GuestBookServiceImpl(GuestBookRepository guestBookRepository) {
        this.guestBookRepository = guestBookRepository;
    }

    public GuestEntry createGuestEntry(GuestEntry guestEntry) {
        return guestBookRepository.save(guestEntry);
    }

    public List<GuestEntry> getAllGuestEntries() {
        return guestBookRepository.findAll();
    }
}
