package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.Product;
import web.repository.ProductRepository;
import web.service.ProductServiceEntity;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public String showProductList(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "product_list";
    }

    @GetMapping("/products/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "add_product";
    }

    @PostMapping("/products/add")
    public String addProduct(@ModelAttribute("product") Product product) {
        productRepository.save(product);
        return "redirect:/products";
    }
}