package com.projetodeestudo.course.config;

import com.projetodeestudo.course.models.entities.Order;
import com.projetodeestudo.course.models.entities.User;
import com.projetodeestudo.course.repositories.OrderRepository;
import com.projetodeestudo.course.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile(value = "test")
public class TestConfig implements CommandLineRunner {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public TestConfig(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    //EXECUTADO QUANDO A APLICAÇÃO É INICIADA
    @Override
    public void run(String... args) throws Exception {
        User u1 = new User("Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User("Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));

        Order o1 = new Order(Instant.parse("2019-06-20T19:53:07Z"), u1);
        Order o2 = new Order(Instant.parse("2019-07-21T03:42:10Z"), u2);
        Order o3 = new Order(Instant.parse("2019-07-22T15:21:22Z"), u1);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
