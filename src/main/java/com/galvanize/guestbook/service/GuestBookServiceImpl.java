package com.galvanize.guestbook.service;

import com.galvanize.guestbook.exception.APIException;
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

    public GuestEntry createGuestEntry(GuestEntry guestEntry) throws APIException {
        GuestEntry guestEntry1;
        try{
            String test = null;
            test.length();
            guestEntry1 = guestBookRepository.save(guestEntry);
        }catch(Exception exp){
            throw new APIException("1000","This is expection testing");
        }

        return guestEntry1;
    }

    public List<GuestEntry> getAllGuestEntries() {
        return guestBookRepository.findAll();
    }
}
