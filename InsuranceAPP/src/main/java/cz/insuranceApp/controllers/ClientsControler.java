package cz.insuranceApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clients")
public class ClientsControler {

    @GetMapping
    public String renderIndex(){
        return "pages/clients/index";
    }

    @GetMapping("/create")
    public String renderCreateForm(){
        return "pages/clients/create";
    }

}
