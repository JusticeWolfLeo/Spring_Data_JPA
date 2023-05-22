package web.service;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceEntity {
  private final UserRepository repo;
  private Scope entityManager;

  public List<User> listAll() {
    return (List<User>) repo.findAll();
  }

  public User getById(Long id) {
    return repo.findById(id).get();
  }

  public User saveUser(User user) {
    return repo.save(user);
  }

  public void updateUser(User user) {
    if (!repo.existsById(user.getId())) {
      throw new RuntimeException("Не удалось найти пользовтаеля с id:" + user.getId());
    }
    repo.save(user);
  }

  public void delete(User user) {
    entityManager.remove(String.valueOf(user));
  }

  public User findByEmail(String email){
    return repo.findByEmail(email);
  }
  public Optional<User> findById(Long userId) {
    return repo.findById(userId);
  }
}
