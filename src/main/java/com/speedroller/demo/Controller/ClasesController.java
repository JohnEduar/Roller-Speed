package com.speedroller.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clases")
public class ClasesController {
    @GetMapping
    public String index() {
        return "clases";
    }
}
