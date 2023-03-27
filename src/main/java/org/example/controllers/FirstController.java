package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        //      System.out.println(name + " " + surname + " " + "hi");

        model.addAttribute("message1", name + " " + surname + " " + "hi");
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) Integer a,
                             @RequestParam(value = "b", required = false) Integer b,
                             @RequestParam(value = "action", required = false) String action,
                             Model model) {
        if ((action == null) || (a == null) || (b == null)) {
            return "first/calculator";
        }
        if (action.equals("multiplication")) {
            model.addAttribute("result", "Result is " + a * b);
            return "first/calculator";
        }
        if (action.equals("addition")) {
            model.addAttribute("result", "Result is " + (a + b));
            return "first/calculator";
        }
        if (action.equals("subtraction")) {
            model.addAttribute("result", "Result is " + (a - b));
            return "first/calculator";
        }
        if (action.equals("division")) {
            model.addAttribute("result", "Result is " + a / (double)b);
            return "first/calculator";
        }

        return "first/calculator";
    }


}
