package org.example.culinaryblog.Controlles;

import org.example.culinaryblog.Models.Blog;
import org.example.culinaryblog.Repo.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class BlogController {
    @Autowired
    private IBlogRepository iBlogRepository;
    @GetMapping("/blog")
    public String blogMain(Model model){
        Iterable<Blog> posts = iBlogRepository.findAll();
        model.addAttribute("posts", posts);
        return "Pages/Blog/blog";
    }
    @GetMapping("/blog/new")
    public String blogNew(Model model){
        return "Pages/Blog/newBlog";
    }
    @PostMapping("/blog/new")
    public String addBlogNew (@RequestParam String title, @RequestParam String description, Model model){
        Blog postModel = new Blog(title, description);
        iBlogRepository.save(postModel);
        return "redirect:/blog";
    }
    @GetMapping("/blog/{id}")
    public String blogById (@PathVariable(value = "id") long id, Model model){
        if(!iBlogRepository.existsById(id)){
            return "redirect:/blog";
        }
        Blog blog = iBlogRepository.findById(id).get();
        model.addAttribute("blog", blog);
        return "Pages/Blog/blogOne";
    }
    @GetMapping("/blog/{id}/edit")
    public String editBlogById(@PathVariable(value = "id") long id, Model model) {
        if (!iBlogRepository.existsById(id)) {
            return "redirect:/blog";
        }
        Blog blog = iBlogRepository.findById(id).get();
        model.addAttribute("blog", blog);
        return "Pages/Blog/editBlog";
    }

    @PostMapping("/blog/{id}/edit")
    public String updateBlogById(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String description, Model model) {
        if (!iBlogRepository.existsById(id)) {
            return "redirect:/blog";
        }
        Blog postModel = iBlogRepository.findById(id).get();
        postModel.setTitle(title);
        postModel.setDescription(description);
        postModel.setCreatedAt(LocalDateTime.now());
        iBlogRepository.save(postModel);
        return "redirect:/blog";
    }
    @GetMapping("/blog/{id}/delete")
    public String deleteBlogById(@PathVariable(value = "id") long id) {
        if (!iBlogRepository.existsById(id)) {
            return "redirect:/blog";
        }
        iBlogRepository.deleteById(id);
        return "redirect:/blog";
    }
}
