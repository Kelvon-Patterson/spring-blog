package com.codeup.springblog.controllers;

import com.codeup.springblog.daos.PostRepository;
import com.codeup.springblog.daos.UsersRepository;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

//@PostMapping("/post/create")
//public String save(@RequestParam(value = "title") String title,
//                   @RequestParam(value = "body") String body){
//    User user = usersDao.getById(1L);
//    Post newPost = new Post(title, body, user);
//    Post savedPost = postDao.save(newPost);
//    return "redirect:/post/" + savedPost.getId();
//}
    @PostMapping(value="/post/edit/{id}")
    public String editPost(@PathVariable long id, @RequestParam(name="editPost") String title,@RequestParam String body ) {
        Post post = new Post(id, title,body);
        postDao.save(post);
        return "redirect:/post/"+ id;
    }

    @PostMapping(value="/post/add/")
    public String addPost( @RequestParam(name="addPost") String title,@RequestParam String body ) {
        Post post = new Post(title,body);
        postDao.save(post);
        return "redirect:/post";
    }

    @GetMapping(value="/post/edit/{id}")
    public String editPost(@PathVariable long id, Model model ) {
       model.addAttribute("editPost", postDao.getById(id));
        return "post/edit";
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
