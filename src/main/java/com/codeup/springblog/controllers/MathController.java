package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {
    @RequestMapping(value = "add/{num1}/and/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String addAnd(@PathVariable int num1, @PathVariable int num2) {
   return num1 + " plus " + num2 +" is " + (num1 + num2);
    }

    @RequestMapping(value = "add/{num1}/to/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String addTo(@PathVariable int num1, @PathVariable int num2) {
        return num1 + " plus " + num2 +" is " + (num1 + num2);
    }

    @RequestMapping(value = "subtract/{num1}/from/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String subtract(@PathVariable int num1, @PathVariable int num2) {
        return num1 + " minus " + num2 +" is " + (num1 - num2);
    }

    @RequestMapping(value = "multiply/{num1}/and/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String multiply(@PathVariable int num1, @PathVariable int num2) {
        return num1 + " times " + num2 +" is " + (num1 * num2);
    }

    @RequestMapping(value = "divide/{num1}/by/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String add(@PathVariable int num1, @PathVariable int num2) {
        return num1 + " divided by " + num2 +" is " + (num1 / num2);
    }



}
