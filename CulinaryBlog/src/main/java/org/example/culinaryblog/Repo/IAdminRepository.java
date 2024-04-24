package org.example.culinaryblog.Repo;

import org.example.culinaryblog.Models.Admin;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IAdminRepository extends CrudRepository<Admin, Long> {
    // Метод для отримання всіх адміністраторів
    List<Admin> getAllAdmins();

    // Метод для отримання адміністратора за ідентифікатором
    Admin getAdminById(Long id);

    // Метод для додавання нового адміністратора
    void addAdmin(Admin admin);

    // Метод для оновлення інформації про адміністратора
    void updateAdmin(Long id, Admin updatedAdmin);

    // Метод для видалення адміністратора за ідентифікатором
    void deleteAdmin(Long id);

}