package com.example.primerProyectoSerbatic_actualizacion1.service;

import com.example.primerProyectoSerbatic_actualizacion1.entity.Menu;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MenuService { //interfaz que define todos los metodos
    List<Menu> findAll();  //busca todos los menus
    Menu findById(Long id);
    List<Menu> findByPlateDate(Date findByPlateDate);

    Menu save(Menu menu);
}
