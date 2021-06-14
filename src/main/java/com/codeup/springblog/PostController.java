package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao=postDao;
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


//    @GetMapping(value="/post/create")
//    @ResponseBody
//    public String createPostForm(Model model){
//        model.addAttribute("createPost", postDao.save(postDao.findByTitle("")));
//
//        return "post/show";
//    }

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
    // Still need GetMapping to serve edit post page
    //editPost should be name of input

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
