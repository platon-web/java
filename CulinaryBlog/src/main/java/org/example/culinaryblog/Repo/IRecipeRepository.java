package org.example.culinaryblog.Repo;

import org.example.culinaryblog.Models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface IRecipeRepository extends CrudRepository<Recipe, Long> {

}