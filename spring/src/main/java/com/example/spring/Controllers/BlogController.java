package com.example.spring.Controllers;


import com.example.spring.Models.PostModel;
import com.example.spring.Repo.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {
    @Autowired
    private IPostRepository IPostRepository;
    @GetMapping("/blog")
    public String blogMain(Model model){
        Iterable<PostModel> posts = IPostRepository.findAll();
        model.addAttribute("posts", posts);
        return "blogMain";
    }
    @GetMapping("/blog/new")
    public String blogAdd(Model model){
        return "blogNew";
    }
    @PostMapping("/blog/new")
    public String blogPostAdd(@RequestParam String title, @RequestParam String description, Model model){
        PostModel postModel = new PostModel(title, description);
        IPostRepository.save(postModel);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model){
        if(!IPostRepository.existsById(id)){
            return "redirect:/blog";
        }
        PostModel postModel = IPostRepository.findById(id).get();
        model.addAttribute("post", postModel);
        return "post";
    }

    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long id, Model model){
        if(!IPostRepository.existsById(id)){
            return "redirect:/blog";
        }
        PostModel postModel = IPostRepository.findById(id).get();
        model.addAttribute("post", postModel);
        return "blogEdit";
    }
    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String description, Model model){
        PostModel postModel = IPostRepository.findById(id).get();
        postModel.setTitle(title);
        postModel.setDescription(description);
        IPostRepository.save(postModel);
        return "redirect:/blog";
    }
    @GetMapping("/blog/{id}/remove")
    public String blogPostDelete(@PathVariable(value = "id") long id, Model model){
        PostModel postModel = IPostRepository.findById(id).get();
        IPostRepository.delete(postModel);
        return "redirect:/blog";
    }

}
