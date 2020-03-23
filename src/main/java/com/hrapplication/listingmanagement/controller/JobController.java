package com.hrapplication.listingmanagement.controller;

import com.hrapplication.listingmanagement.domain.JobAddForm;
import com.hrapplication.listingmanagement.service.ApplicantService;
import com.hrapplication.listingmanagement.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class JobController {
    private final JobService jobService;
    private final ApplicantService applicantService;

    @Autowired
    public JobController(JobService jobService, ApplicantService applicantService) {
        this.jobService = jobService;
        this.applicantService = applicantService;
    }

    @RequestMapping("/job/add")
    public ModelAndView jobAddPage() {
        return new ModelAndView("jobCreate","jobAddForm", new JobAddForm());
    }

    @RequestMapping(value = "/jobs", method = RequestMethod.POST)
    public String handleJobAdd(@Valid @ModelAttribute("jobForm") JobAddForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/job/add";
        }
        jobService.addJob(form);
        return "redirect:/home";
    }

    @RequestMapping("/jobs")
    public ModelAndView getJobsPage() {
        return new ModelAndView("jobListing","jobs", jobService.getJobs());
    }

    @RequestMapping(value = "/job/{id}")
    public String handleJobDelete(@PathVariable Integer id) {
        jobService.deleteJobById(id);
        return "redirect:/jobs";
    }

    @RequestMapping(value = {"/jobDetail/{id}"})
    public ModelAndView handleJobDetails(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("jobListingDetail");
        modelAndView.addObject("jobDetail", jobService.getJobDetail(id));
        modelAndView.addObject("applicants", applicantService.getApplicants());
        return modelAndView;
    }
}
