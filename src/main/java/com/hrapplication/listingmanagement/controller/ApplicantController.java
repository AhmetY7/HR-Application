package com.hrapplication.listingmanagement.controller;

import com.hrapplication.listingmanagement.domain.ApplicantAddForm;
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
public class ApplicantController {
    private final ApplicantService applicantService;
    private final JobService jobService;
    private int id;

    @Autowired
    public ApplicantController(ApplicantService applicantService, JobService jobService) {
        this.applicantService = applicantService;
        this.jobService = jobService;
    }

    @RequestMapping("/active")
    public ModelAndView getActiveJobs() { return new ModelAndView("activeJobs", "jobs", jobService.getJobs()); }



    @RequestMapping(value = "/active", method = RequestMethod.POST)
    public String handleJobAdd(@Valid @ModelAttribute("applicantForm") ApplicantAddForm form, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "";
        }
        form.setJobId(id);
        applicantService.addApplicant(form);
        return "redirect:/active";
    }

    @RequestMapping(value = {"/activeDetail/{id}"})
    public ModelAndView handleActiveJobDetails(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("jobApplicationDetail");
        modelAndView.addObject("jobDetail",jobService.getJobDetail(id));
        this.id = jobService.getJobDetail(id).getId();
        modelAndView.addObject("applicantForm", new ApplicantAddForm());
        return modelAndView;
    }
}
