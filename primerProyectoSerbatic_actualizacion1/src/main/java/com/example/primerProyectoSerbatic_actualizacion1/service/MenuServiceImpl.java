package com.example.primerProyectoSerbatic_actualizacion1.service;

import com.example.primerProyectoSerbatic_actualizacion1.entity.Menu;
import com.example.primerProyectoSerbatic_actualizacion1.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuRepository repository;

    public MenuServiceImpl(MenuRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Menu> findAll() {
        return this.repository.findAll();
    }

    /*@Override
    public Optional<Menu> findById(Long id) {
        return this.repository.findById(id);
    }*/
    @Override
    public Menu findById(Long id) {
        Optional<Menu> menuOp=repository.findById(id);
        if(menuOp.isPresent()){
            Menu m=menuOp.get();
            return m;
        }else{
            return (Menu) ResponseEntity.notFound();
        }
        //return this.repository.findById(id);
    }

    @Override
    public List<Menu> findByPlateDate(Date plateDate) {
        return this.repository.findByPlateDate(plateDate);
    }

    @Override
    public Menu save(Menu menu){
        this.repository.save(menu);
        return menu;
    }
}