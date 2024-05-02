package com.example.primerProyectoSerbatic_actualizacion1.repository;

import com.example.primerProyectoSerbatic_actualizacion1.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface MenuRepository extends JpaRepository<Menu,Long> {
    List<Menu> findByPlateDate(Date findByPlateDate);
}
