package com.hrapplication.listingmanagement.repository;

import com.hrapplication.listingmanagement.domain.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, Integer> {
}
