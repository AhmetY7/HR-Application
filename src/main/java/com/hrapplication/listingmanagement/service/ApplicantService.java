package com.hrapplication.listingmanagement.service;

import com.hrapplication.listingmanagement.domain.Applicant;
import com.hrapplication.listingmanagement.domain.ApplicantAddForm;

public interface ApplicantService {
    void addApplicant(ApplicantAddForm form);
    Iterable<Applicant> getApplicants();
}
