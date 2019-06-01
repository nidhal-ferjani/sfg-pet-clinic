package com.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Nidhal on 01/06/2019.
 */
@Controller
public class IndexController {

    @RequestMapping({"", "/", "index", "/index.html"})
    public String index(){
        return "index";
    }
}
