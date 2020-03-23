package com.hrapplication.listingmanagement.repository;

import com.hrapplication.listingmanagement.domain.Applicant;
import org.springframework.data.repository.CrudRepository;

public interface ApplicantRepository extends CrudRepository<Applicant, Integer> {
}
