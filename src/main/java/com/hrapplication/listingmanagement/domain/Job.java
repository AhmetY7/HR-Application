package com.hrapplication.listingmanagement.domain;


import javax.persistence.*;

@Entity
@Table(name="jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false, updatable = false)
    private int id;
    @Column(name="title", nullable = false)
    private String title;
    @Column(name="description", nullable = false)
    private String description;
    @Column(name="people_to_hire", nullable = false)
    private int peopleToHire;
    @Column(name="last_application_date", nullable = false)
    private String lastApplicationDate;
    public Job() {}

    public Job(String title, String description, int peopleToHire, String lastApplicationDate) {
        this.title = title;
        this.description = description;
        this.peopleToHire = peopleToHire;
        this.lastApplicationDate = lastApplicationDate;
    }

    public int getId() {
        return id;
    }

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
