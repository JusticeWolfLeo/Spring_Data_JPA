package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.Order;
import web.model.Product;
import web.model.User;
import web.repository.OrderRepository;
import web.repository.ProductRepository;
import web.repository.UserRepository;
import web.service.ProductServiceEntity;
import web.service.UserServiceEntity;

import java.util.List;
import java.util.Optional;

public class ProfileController {
    private UserServiceEntity userServiceEntity;
    private OrderRepository orderRepository;

    @GetMapping("/profile/{userId}")
    public String showUserProfile(@PathVariable("userId") Long userId, Model model) {
        Optional<User> user = userServiceEntity.findById(userId);
        List<Order> orders = orderRepository.findByUserId(userId);

        model.addAttribute("user", user);
        model.addAttribute("orders", orders);

        return "profile";
    }
}
