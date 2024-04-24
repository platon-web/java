package org.example.culinaryblog.Repo;

import org.example.culinaryblog.Models.Rating;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRatingRepository extends CrudRepository<Rating, Long> {
    List<Rating> getAllRatingsForRecipeOrBlog(Long recipeOrBlogId);

    // Метод для отримання рейтингу за ідентифікатором
    Rating getRatingById(Long id);

    // Метод для додавання нового рейтингу
    void addRating(Rating rating);

    // Метод для оновлення інформації про рейтинг
    void updateRating(Long id, Rating updatedRating);

    // Метод для видалення рейтингу за його ідентифікатором
    void deleteRating(Long id);

}