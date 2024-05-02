package com.example.primerProyectoSerbatic_actualizacion1.repository;

import com.example.primerProyectoSerbatic_actualizacion1.entity.OrderMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderMenu,Long> {
    List<OrderMenu> findByOrderId(Long id);
}
