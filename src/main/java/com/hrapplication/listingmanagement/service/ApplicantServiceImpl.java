package com.hrapplication.listingmanagement.service;

import com.hrapplication.listingmanagement.domain.Applicant;
import com.hrapplication.listingmanagement.domain.ApplicantAddForm;
import com.hrapplication.listingmanagement.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class ApplicantServiceImpl implements ApplicantService {
    private final ApplicantRepository applicantRepository;

    @Autowired
    public ApplicantServiceImpl(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    public void addApplicant(ApplicantAddForm form) {
        Applicant applicant = new Applicant(form.getName(), form.getEmail(), form.getPhone(), form.getAddress(),form.getThoughts(), form.getJobId());
        applicantRepository.save(applicant);
    }

    @Override
    public Iterable<Applicant> getApplicants() {
        return applicantRepository.findAll();
    }
}
