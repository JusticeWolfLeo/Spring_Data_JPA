package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Product;
import web.repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceEntity {
    private final ProductRepository productRepo;
    @PersistenceContext
    private EntityManager entityManager;

    public Product findById(Long id) {
        return entityManager.find(Product.class, id);
    }

    public Product saveProduct(Product product) {
        entityManager.persist(product);
        return product;
    }

    public void delete(Product product) {
        entityManager.remove(product);
    }

    public List<Product> listAll() {
        return (List<Product>) productRepo.findAll();
    }
}
