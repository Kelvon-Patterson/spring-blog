package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RollDiceController {



        @GetMapping("/roll-dice")
        public String welcomeToDiceRoll(){
            return "roll-dice";
        }

    @RequestMapping(value = "/roll-dice/{userNum}", method = RequestMethod.GET)
    public String diceRoll(@PathVariable int userNum, Model model) {
            int diceNum = (int) (Math.random() * 6 - 1 + 1) + 1;

            model.addAttribute("diceRoll", diceNum);

            model.addAttribute("userNum", userNum);
            if(diceNum == userNum){
                    model.addAttribute("match", "YOU WIN");
            }else{
               model.addAttribute("match", "YOU LOSE");
            }
        return "roll-dice";
    }


}
