package com.hrapplication.listingmanagement.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ApplicantAddForm {
    @NotEmpty
    @Size(max = 45)
    private String name;
    @NotEmpty
    @Size(max = 45)
    private String email;
    @NotEmpty
    @Size(max = 45)
    private String phone;
    @NotEmpty
    @Size(max = 150)
    private String address;
    @NotEmpty
    @Size(max = 250)
    private String thoughts;

    private int job_id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getThoughts() {
        return thoughts;
    }

    public void setThoughts(String thoughts) {
        this.thoughts = thoughts;
    }

    public int getJobId() {
        return job_id;
    }

    public void setJobId(int job_id) {
        this.job_id = job_id;
    }
}
