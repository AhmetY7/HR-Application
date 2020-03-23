package com.hrapplication.listingmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JobListingController {
    @RequestMapping(value = {"/"})
    public String getHomePage() {
        return "redirect:/active";
    }

    @RequestMapping(value = "/login")
    public String getLogin() { return "login"; }
}
