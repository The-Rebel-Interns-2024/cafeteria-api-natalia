package com.example.primerProyectoSerbatic_actualizacion1.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.Serializable;
import java.util.Optional;

@Entity
public class Menu implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date plateDate;
    private String plateName;
    private double price;

    public Menu() {
    }

    public Menu(Long id, Date plateDate, String plateName, double price) {
        this.id = id;
        this.plateDate = plateDate;
        this.plateName = plateName;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPlateDate() {
        return plateDate;
    }

    public void setPlateDate(Date plateDate) {
        this.plateDate = plateDate;
    }

    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return "Menu{" +
                "id=" + id +
                ", plateDate=" + sdf.format(plateDate) +
                ", plateName='" + plateName + '\'' +
                ", price=" + price +
                '}';
    }
}