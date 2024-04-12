package com.example.spring.Repo;

import com.example.spring.Models.PostModel;
import org.springframework.data.repository.CrudRepository;

public interface IPostRepository extends CrudRepository<PostModel, Long> {

}
