package org.example.culinaryblog.Repo;

import org.example.culinaryblog.Models.Blog;
import org.springframework.data.repository.CrudRepository;

public interface IBlogRepository extends CrudRepository<Blog, Long> {

}