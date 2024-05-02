package com.example.primerProyectoSerbatic_actualizacion1.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@Entity
public class OrderMenu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Long menuId;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date menuDate;
    private double menuPrice;
    private ArrayList<Menu> menu; //objeto de tipo menu que contiene todos los datos del menu

    public OrderMenu() {
    }

    public OrderMenu(Long orderId, Long menuId, Date menuDate, double menuPrice, ArrayList<Menu> menu) {
        this.orderId = orderId;
        this.menuId = menuId;
        this.menuDate = menuDate;
        this.menuPrice = menuPrice;
        this.menu = menu;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Date getMenuDate() {
        return menuDate;
    }

    public void setMenuDate(Date menuDate) {
        this.menuDate = menuDate;
    }

    public double getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(double menuPrice) {
        this.menuPrice = menuPrice;
    }

    public ArrayList<Menu> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<Menu> menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", menuId=" + menuId +
                ", menuDate=" + menuDate +
                ", menuPrice=" + menuPrice +
                ", menu=" + menu +
                '}';
    }
}
