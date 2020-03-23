package com.hrapplication.listingmanagement.service;

import com.hrapplication.listingmanagement.domain.Job;
import com.hrapplication.listingmanagement.domain.JobAddForm;
import com.hrapplication.listingmanagement.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;
    @Autowired
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }
    public void addJob(JobAddForm form) {
        Job job = new Job(form.getTitle(),form.getDescription(),form.getPeopleToHire(),form.getLastApplicationDate());
        jobRepository.save(job);
    }

    @Override
    public Iterable<Job> getJobs() {
        return jobRepository.findAll();
    }

    @Override
    public void deleteJobById(int id) {
        jobRepository.deleteById(id);
    }

    @Override
    public Job getJobDetail(int id) {
        Optional<Job> jobDetail = jobRepository.findById(id);
        return jobDetail.orElse(null);
    }
}
