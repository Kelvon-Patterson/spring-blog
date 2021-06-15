package com.codeup.springblog.controllers;

import com.codeup.springblog.daos.PostRepository;
import com.codeup.springblog.daos.UsersRepository;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PostController {
    //private field to store injected repository
    private  PostRepository postDao;

    private  UsersRepository usersDao;


    public PostController(PostRepository postRepository, UsersRepository usersRepository){
        usersDao = usersRepository;
        postDao = postRepository;
    }

    @GetMapping(value = "/post")
    public String indexPage(Model model) {
        model.addAttribute("post", postDao.findAll());
        return "post/index";
    }


    @GetMapping(value="/post/{id}")
    public String onePost(@PathVariable long id, Model model){
        model.addAttribute("singlePost", postDao.getById(id));
        return "post/show";
    }

    @GetMapping(value="/post/{id}/edit")
    public String editPost(@PathVariable long id, Model model ) {
        //find a post
        Post postToEdit = postDao.getById(id);
        model.addAttribute("editPost", postToEdit);
        return "post/edit";
    }

    @PostMapping(value="/post/{id}/edit")
    public String editPost(@PathVariable long id,
                           @ModelAttribute Post post, RedirectAttributes redirect) {
        //save changes
        post.setUser(usersDao.getById(1L));
        postDao.save(post); // update post set title= ? where id =?
        redirect.addFlashAttribute("successfulSave","This post was successfully saved");
        return "redirect:/post/"+ id;
    }

    @PostMapping(value="/post/add/")
    public String addPost( @RequestParam(name="addPost") String title,@RequestParam String body ) {
        Post post = new Post(title,body);
        postDao.save(post);
        return "redirect:/post";
    }



    @GetMapping(value= "/post/delete/{id}")
    public String deletePost(@PathVariable long id ){
        postDao.deleteById(id);
        return "redirect:/post/index";
    }

    @RequestMapping(value="/post/create", method = RequestMethod.POST)
    @ResponseBody
    public String createPost(String createPost){
        return "create a new post";
    }
}
