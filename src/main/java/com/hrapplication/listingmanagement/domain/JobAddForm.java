package com.hrapplication.listingmanagement.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class JobAddForm {
    @NotEmpty
    @Size(max = 50)
    private String title;
    @NotEmpty
    @Size(max = 250)
    private String description;
    private int peopleToHire;
    @NotEmpty
    private String lastApplicationDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPeopleToHire() {
        return peopleToHire;
    }

    public void setPeopleToHire(int peopleToHire) {
        this.peopleToHire = peopleToHire;
    }

    public String getLastApplicationDate() {
        return lastApplicationDate;
    }

    public void setLastApplicationDate(String lastApplicationDate) {
        this.lastApplicationDate = lastApplicationDate;
    }
}
