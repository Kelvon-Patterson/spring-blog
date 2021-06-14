package com.codeup.springblog.controllers;

import com.codeup.springblog.daos.AdsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdController {

    private final AdsRepository adDao;

    public AdController(AdsRepository adDao){
        this.adDao = adDao;
    }

    @GetMapping("/ads")
    public String index(Model model){
        model.addAttribute("ads", adDao.findAll());

        model.addAttribute("topAd", adDao.findByTitle("bicycle north side"));

        model.addAttribute("searchAd", adDao.findByTitleLike("% childcare %"));
    return "ads/index";
    }


}
