package com.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Nidhal on 02/06/2019.
 */

@RequestMapping("/owners")
@Controller
public class OwnerController {

    @RequestMapping({"/", "/index", "/index.html",""})
    public String listOwners() {
        System.out.println("je suis dans controller Owners");
        return "owners/index";
    }
}
