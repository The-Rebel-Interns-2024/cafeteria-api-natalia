package com.example.primerProyectoSerbatic_actualizacion1.controller;
import com.example.primerProyectoSerbatic_actualizacion1.entity.OrderMenu;
import com.example.primerProyectoSerbatic_actualizacion1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api_menu")
public class OrderController {
    @Autowired
    private OrderService ordService;

    @GetMapping("/orderMenu/")
    public ResponseEntity<List<OrderMenu>> findAllOrd(){
        /*List<OrderMenu> ordList=this.ordService.findAllOrd();
        if(ordList.isEmpty()){
            return  ResponseEntity.notFound().build();
        }*/
        return ResponseEntity.ok(ordService.findAllOrd());
    }

    @GetMapping("/orderMenu/{id}")
    public ResponseEntity<OrderMenu> findByOrderId(@PathVariable Long id){
        /*return this.ordService.findByOrderId(id)
                .stream().map(ResponseEntity::ok)
                .findAny().orElseGet(()-> ResponseEntity.notFound().build());*/
        return ResponseEntity.ok(ordService.findByOrderId(id));
    }

    /*@GetMapping("/order/{id}")
    public ResponseEntity<Order> findByOrderId(@PathVariable Long orderId){
        OrderService ordS= new OrderService() {
            @Override
            public List<Order> findAllOrd() {
                return null;
            }

            @Override
            public List<Order> findByOrderId(Long orderId) {
                return null;
            }

            final List<Order> oList=ordS.findByOrderId(orderR,orderId);
        };


        *//*return this.ordService.findByOrderId(orderId)
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());*//*

        return null;
    }*/

    @PostMapping("/createOrder")
    public ResponseEntity<OrderMenu> createOrder(@RequestBody OrderMenu orderMenu){
        OrderMenu o= ordService.save(orderMenu);
        orderMenu.toString();
        return ResponseEntity.ok(o);
    }

    @PutMapping("/editOrder/{id}")
    public ResponseEntity<OrderMenu> updateOrder(@PathVariable Long id, @RequestBody OrderMenu orderMenu){
        OrderMenu newOrderMenu = (OrderMenu) ordService.findByOrderId(id);
        newOrderMenu.setMenuId(orderMenu.getMenuId());
        newOrderMenu.setMenuDate(orderMenu.getMenuDate());
        newOrderMenu.setMenuPrice(orderMenu.getMenuPrice());
        newOrderMenu.setMenu(orderMenu.getMenu());
        return ResponseEntity.ok(ordService.save(orderMenu));
    }
}
