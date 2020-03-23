package com.hrapplication.listingmanagement.service;

import com.hrapplication.listingmanagement.domain.Job;
import com.hrapplication.listingmanagement.domain.JobAddForm;

public interface JobService {
    void addJob(JobAddForm form);
    Iterable<Job> getJobs();
    void deleteJobById(int id);
    Job getJobDetail(int id);
}
