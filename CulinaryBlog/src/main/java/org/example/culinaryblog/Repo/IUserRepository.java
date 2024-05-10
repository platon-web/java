package org.example.culinaryblog.Repo;

import org.example.culinaryblog.Models.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Long> {

     User findByEmail(String username);
}