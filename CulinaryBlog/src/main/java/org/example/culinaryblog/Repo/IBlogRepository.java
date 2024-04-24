package org.example.culinaryblog.Repo;

import org.example.culinaryblog.Models.Blog;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IBlogRepository extends CrudRepository<Blog, Long> {
    List<Blog> getAllBlogs();

    // Метод для отримання блога за ідентифікатором
    Blog getBlogById(Long id);

    // Метод для додавання нового блога
    void addBlog(Blog blog);

    // Метод для оновлення інформації про блог
    void updateBlog(Long id, Blog updatedBlog);

    // Метод для видалення блога за ідентифікатором
    void deleteBlog(Long id);

}