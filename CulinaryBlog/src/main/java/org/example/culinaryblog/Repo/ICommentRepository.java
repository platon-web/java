package org.example.culinaryblog.Repo;

import org.example.culinaryblog.Models.Comment;
import org.springframework.data.repository.CrudRepository;

public interface ICommentRepository extends CrudRepository<Comment, Long> {

}