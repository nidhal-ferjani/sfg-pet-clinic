package com.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Nidhal on 02/06/2019.
 */

@Controller
public class VetController {

    @RequestMapping({"/vets", "/vets/index" ,"/vets/index.html"})
    public  String listVets(){
       return "vets/index";
    }
}
