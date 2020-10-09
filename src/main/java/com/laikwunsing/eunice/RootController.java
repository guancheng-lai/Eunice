package com.laikwunsing.eunice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String root(Model model) {
        model.addAttribute( "msg", "I love you!" );
        return "root";
    }

}
