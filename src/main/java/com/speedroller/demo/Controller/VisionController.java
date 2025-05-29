package com.speedroller.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class VisionController {
    @GetMapping("/vision")
    public String vision() {
        return "vision";
    }
}