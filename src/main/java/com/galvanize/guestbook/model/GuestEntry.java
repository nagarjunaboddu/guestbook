package com.galvanize.guestbook.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GuestEntry {
    @Id
    private String name;
    private String comment;

    public GuestEntry() {
    }

    public GuestEntry(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}
