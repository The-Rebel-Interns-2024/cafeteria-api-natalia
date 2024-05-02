package com.example.primerProyectoSerbatic_actualizacion1.service;
import com.example.primerProyectoSerbatic_actualizacion1.entity.OrderMenu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<OrderMenu> findAllOrd();
    OrderMenu findByOrderId(Long orderId);
    OrderMenu save(OrderMenu orderMenu);
}
