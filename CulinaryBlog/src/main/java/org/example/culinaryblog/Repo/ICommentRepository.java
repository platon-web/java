package org.example.culinaryblog.Repo;

import org.example.culinaryblog.Models.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> getAllCommentsForRecipeOrBlog(Long recipeOrBlogId);

    // Метод для отримання коментаря за його ідентифікатором
    Comment getCommentById(Long id);

    // Метод для додавання нового коментаря
    void addComment(Comment comment);

    // Метод для оновлення інформації про коментар
    void updateComment(Long id, Comment updatedComment);

    // Метод для видалення коментаря за його ідентифікатором
    void deleteComment(Long id);

}