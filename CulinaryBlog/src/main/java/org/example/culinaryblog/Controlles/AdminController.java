package org.example.culinaryblog.Controlles;

import org.example.culinaryblog.Repo.IUserRepository;
import org.springframework.ui.Model;

import org.example.culinaryblog.Models.Recipe;
import org.example.culinaryblog.Models.User;
import org.example.culinaryblog.Repo.IRecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminController {
    private final IRecipeRepository recipeService;
    private final IUserRepository userService;

    public AdminController(IRecipeRepository recipeService, IUserRepository userService) {
        this.recipeService = recipeService;
        this.userService = userService;
    }

    @GetMapping("/recipes")
    public String showRecipes(Model model) {
        Iterable<Recipe> recipes = recipeService.findAll();
        model.addAttribute("recipes", recipes);
        return "admin/recipes";
    }

    @GetMapping("/recipes/{id}/edit")
    public String editRecipe(@PathVariable Long id, Model model) {
        Iterable<Recipe> recipe = (Iterable<Recipe>) recipeService.findById(id).get();
        model.addAttribute("recipe", recipe);
        return "admin/edit_recipe";
    }

    @PostMapping("/recipes/{id}/edit")
    public String updateRecipe(@PathVariable Long id, @ModelAttribute Recipe updatedRecipe) {
        recipeService.findById(id).get();
        return "redirect:/admin/recipes";
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        Iterable<User> users = (Iterable<User>) userService.findAll();
        model.addAttribute("users", users);
        return "admin/users";
    }

    @GetMapping("/users/{id}/edit")
    public String editUser(@PathVariable Long id, Model model) {
        Iterable<User> user = (Iterable<User>) userService.findAll();
        model.addAttribute("user", user);
        return "admin/edit_user";
    }

    @PostMapping("/users/{id}/edit")
    public String updateUser(@PathVariable Long id, @ModelAttribute User updatedUser) {
        userService.findById(id).get();
        return "redirect:/admin/users";
    }
}

//public class BlogController {
//    @Autowired
//    private IPostRepository iPostRepository;
//    @GetMapping("/blog")
//    public String blogMain(Model model){
//        Iterable<PostModel> posts = iPostRepository.findAll();
//        model.addAttribute("posts", posts);
//        return "blogMain";
//    }
//    @GetMapping("/blog/new")
//    public String blogNew(Model model){
//        return "blogNew";
//    }
//    @PostMapping("/blog/new")
//    public String addBlogNew (@RequestParam String title, @RequestParam String description, Model model){
//        PostModel postModel = new PostModel(title, description);
//        iPostRepository.save(postModel);
//        return "redirect:/blog";
//    }
//    @GetMapping("/blog/{id}")
//    public String blogById (@PathVariable(value = "id") long id, Model model){
//        if(!iPostRepository.existsById(id)){
//            return "redirect:/blog";
//        }
//        PostModel postModel = iPostRepository.findById(id).get();
//        model.addAttribute("post", postModel);
//        return "post";
//    }
//    @GetMapping("/blog/{id}/edit")
//    public String editBlogById(@PathVariable(value = "id") long id, Model model) {
//        if (!iPostRepository.existsById(id)) {
//            return "redirect:/blog";
//        }
//        PostModel postModel = iPostRepository.findById(id).get();
//        model.addAttribute("post", postModel);
//        return "blogEdit";
//    }
//    @PostMapping("/blog/{id}/edit")
//    public String updateBlogById(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String description, Model model) {
//        if (!iPostRepository.existsById(id)) {
//            return "redirect:/blog";
//        }
//        PostModel postModel = iPostRepository.findById(id).get();
//        postModel.setTitle(title);
//        postModel.setDescription(description);
//        postModel.setDate(LocalDate.now());
//        iPostRepository.save(postModel);
//        return "redirect:/blog";
//    }
//    @GetMapping("/blog/{id}/delete")
//    public String deleteBlogById(@PathVariable(value = "id") long id) {
//        if (!iPostRepository.existsById(id)) {
//            return "redirect:/blog";
//        }
//        iPostRepository.deleteById(id);
//        return "redirect:/blog";
//    }
//}
//