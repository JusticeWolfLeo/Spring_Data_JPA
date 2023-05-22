package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Order;
import web.model.Product;
import web.repository.OrderRepository;
import web.service.OrderServiceEntity;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    private OrderServiceEntity userRepository;
    private OrderServiceEntity productRepository;

    @GetMapping("/orders")
    public String showOrderList(Model model) {
        List<Order> orders = orderRepository.findAll();
        model.addAttribute("orders", orders);
        return "order_list";
    }

    @PostMapping("/orders/create")
    public String createOrder(@RequestParam("userId") Long userId, @RequestParam("productId") Long productId) {
        Order user = userRepository.findById(userId);

        Order product = productRepository.findById(productId);

        Order order = new Order();
        order.setUser(user);
        order.setProduct(product);
        order.setOrderDate(LocalDate.now());

        orderRepository.save(order);
        return "redirect:/orders";
    }
}