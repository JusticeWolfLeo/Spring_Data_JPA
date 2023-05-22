package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Метод для получения всех записей из таблицы "users"
    List<User> findAll();

    // Метод для получения записи по ее идентификатору из таблицы "users"
    Optional<User> findById(Long id);

    // Метод для добавления новой записи в таблицу "users"
    User save(User user);

    // Метод для удаления записи из таблицы "users" по ее идентификатору
    void deleteById(Long id);
}
