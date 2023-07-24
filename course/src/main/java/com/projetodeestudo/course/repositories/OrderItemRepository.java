package com.projetodeestudo.course.repositories;

import com.projetodeestudo.course.models.entities.OrderItem;
import com.projetodeestudo.course.models.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
