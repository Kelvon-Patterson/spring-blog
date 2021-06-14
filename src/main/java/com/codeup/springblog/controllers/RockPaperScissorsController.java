package com.codeup.springblog.controllers;

import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RockPaperScissorsController {

    @GetMapping("/rock-paper-scissors")
    public String rockPaperScissorsIndex() {
        return "rock-paper-scissors";
    }

    @RequestMapping(value = "/rock-paper-scissors/{userPick}", method = RequestMethod.GET)
    public String automatedOpponentPick(@PathVariable String userPick, Model model) {
        String[] RPS = {"Rock", "Paper", "Scissors"};

        String cpuPick = RPS[(int) (Math.random() * RPS.length)];

        model.addAttribute("cpuPick", cpuPick);

        model.addAttribute("userPick", userPick);

        if (userPick.equalsIgnoreCase(cpuPick)) {
            model.addAttribute("match", "ITS A TIE");

        } else if (userPick.equalsIgnoreCase("rock") && cpuPick.equalsIgnoreCase("scissors")) {
            model.addAttribute("match", "YOU WIN");

        } else if (userPick.equalsIgnoreCase("paper") && cpuPick.equalsIgnoreCase("rock")) {
            model.addAttribute("match", "YOU WIN");

        } else if (userPick.equalsIgnoreCase("scissors") && cpuPick.equalsIgnoreCase("paper")) {
            model.addAttribute("match", "YOU WIN");

        } else if (userPick.equalsIgnoreCase("paper") && cpuPick.equalsIgnoreCase("scissors")) {
            model.addAttribute("match", "YOU LOSE");
        } else if (userPick.equalsIgnoreCase("rock") && cpuPick.equalsIgnoreCase("paper")) {
            model.addAttribute("match", "YOU LOSE");
        } else if (userPick.equalsIgnoreCase("scissors") && cpuPick.equalsIgnoreCase("rock")) {
            model.addAttribute("match", "YOU LOSE");
        }
        return "rock-paper-scissors";
    }
}