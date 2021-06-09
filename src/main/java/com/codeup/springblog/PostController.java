package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    @GetMapping(value = "/post")
    @ResponseBody
    public String indexPage(String indexPost) {
        return "post index page";
    }
    @GetMapping(value="/post/{id}")
    @ResponseBody
    public String onePost(String onePost){
        return "view and individual post";
    }

    @GetMapping(value="/post/create")
    @ResponseBody
    public String createPostForm(String createPostForm){
        return "view the form for creating a post";
    }

    @RequestMapping(value="/post/create", method = RequestMethod.POST)
    @ResponseBody
    public String createPost(String createPost){
        return "create a new post";
    }
}
