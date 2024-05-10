package org.example.culinaryblog.Controlles;

import org.example.culinaryblog.Models.Blog;
import org.example.culinaryblog.Models.Recipe;
import org.example.culinaryblog.Repo.IRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class RecipeController {
    @Autowired
    private IRecipeRepository iRecipeRepository;
    @GetMapping("/recipe")
    public String recipeMain(Model model){
        Iterable<Recipe> posts = iRecipeRepository.findAll();
        model.addAttribute("recipe", posts);
        return "Pages/recipe/recipe";
    }
    @GetMapping("/recipe/new")
    public String recipeNew(Model model){
        return "Pages/Recipe/newRecipe";
    }
    @PostMapping("/recipe/new")
    public String addRecipeNew (@RequestParam String title, @RequestParam String description, @RequestParam String ingredients, @RequestParam String instructions, Model model){
        Recipe postModel = new Recipe(title, description, ingredients, instructions);
        iRecipeRepository.save(postModel);
        return "redirect:/recipe";
    }
    @GetMapping("/recipe/{id}")
    public String recipeById (@PathVariable(value = "id") long id, Model model){
        if(!iRecipeRepository.existsById(id)){
            return "redirect:/recipe";
        }
        Recipe recipe = iRecipeRepository.findById(id).get();
        model.addAttribute("recipe", recipe);
        return "Pages/Recipe/recipeOne";
    }
    @GetMapping("/recipe/{id}/edit")
    public String editRecipeById(@PathVariable(value = "id") long id, Model model) {
        if (!iRecipeRepository.existsById(id)) {
            return "redirect:/recipe";
        }
        Recipe recipe = iRecipeRepository.findById(id).get();
        model.addAttribute("recipe", recipe);
        return "Pages/Recipe/editRecipe";
    }

    @PostMapping("/recipe/{id}/edit")
    public String updateRecipeById(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String description, @RequestParam String ingredients, @RequestParam String instructions, Model model) {
        if (!iRecipeRepository.existsById(id)) {
            return "redirect:/recipe";
        }
        Recipe recipe = iRecipeRepository.findById(id).get();
        recipe.setTitle(title);
        recipe.setDescription(description);
        recipe.setIngredients(ingredients);
        recipe.setInstructions(instructions);
        recipe.setCreatedAt(LocalDateTime.now());
        iRecipeRepository.save(recipe);
        return "redirect:/recipe";
    }
    @GetMapping("/recipe/{id}/delete")
    public String deleteRecipeById(@PathVariable(value = "id") long id) {
        if (!iRecipeRepository.existsById(id)) {
            return "redirect:/recipe";
        }
        iRecipeRepository.deleteById(id);
        return "redirect:/recipe";
    }
}
