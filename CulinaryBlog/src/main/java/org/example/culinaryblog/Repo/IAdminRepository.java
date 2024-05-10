package org.example.culinaryblog.Repo;

import org.example.culinaryblog.Models.Admin;
import org.springframework.data.repository.CrudRepository;

public interface IAdminRepository extends CrudRepository<Admin, Long> {

}