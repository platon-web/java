package org.example.culinaryblog.Repo;

import org.example.culinaryblog.Models.Rating;
import org.springframework.data.repository.CrudRepository;

public interface IRatingRepository extends CrudRepository<Rating, Long> {

}