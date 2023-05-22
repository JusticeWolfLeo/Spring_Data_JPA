package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Order;
import web.repository.OrderRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceEntity {
  @PersistenceContext
  private EntityManager entityManager;

  public Order findById(Long id) {
    return entityManager.find(Order.class, id);
  }
  public void save(Order order) {
    entityManager.persist(order);
  }

  public void delete(Order order) {
    entityManager.remove(order);
  }
}
