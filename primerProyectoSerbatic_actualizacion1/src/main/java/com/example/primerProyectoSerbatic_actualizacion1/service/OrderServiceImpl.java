package com.example.primerProyectoSerbatic_actualizacion1.service;

import com.example.primerProyectoSerbatic_actualizacion1.entity.Menu;
import com.example.primerProyectoSerbatic_actualizacion1.entity.OrderMenu;
import com.example.primerProyectoSerbatic_actualizacion1.repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepo;

    public OrderServiceImpl(OrderRepository orderRepo){
        this.orderRepo=orderRepo;
    }
    @Override
    public List<OrderMenu> findAllOrd() {
        return this.orderRepo.findAll();
    }

    /*@Override
    public List<OrderMenu> findByOrderId(Long orderId) {
        return this.orderRepo.findByOrderId(orderId);
    }*/
    @Override
    public OrderMenu findByOrderId(Long id) {
        Optional<OrderMenu> menuOp=orderRepo.findById(id);
        if(menuOp.isPresent()){
            OrderMenu ordM=menuOp.get();
            return ordM;
        }else{
            return (OrderMenu) ResponseEntity.notFound();
        }
        //return this.repository.findById(id);
    }

    @Override
    public OrderMenu save(OrderMenu orderMenu) {
        this.orderRepo.save(orderMenu);
        return orderMenu;
    }
}
