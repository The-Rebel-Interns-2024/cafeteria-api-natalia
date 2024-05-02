package com.example.primerProyectoSerbatic_actualizacion1.controller;
import com.example.primerProyectoSerbatic_actualizacion1.entity.Menu;
import com.example.primerProyectoSerbatic_actualizacion1.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.*;

//@CrossOrigin(origins = "http://localhost:8081")
@SuppressWarnings({"CommentedOutCode", "ForLoopReplaceableByForEach"})
@RestController
@RequestMapping("/api_menu")
public class MenuController {
    @Autowired
    private final MenuService mService;

    public MenuController(MenuService mService) {
        this.mService = mService;
    }

    /*
    GET http://localhost:8080/api/menuV2
     */
    @GetMapping("/")
    public ResponseEntity<List<Menu>> findAll(){
        /*List<Menu> menuList=this.mService.findAll();
        if(menuList.isEmpty()){
            return ResponseEntity.notFound().build(); //si esta vacio devuelve error notFound
        }*/
        return ResponseEntity.ok(mService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> findById(@PathVariable Long id){
        /*return this.mService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());*/
        return ResponseEntity.ok(mService.findById(id));

    }

    @SuppressWarnings("CallToPrintStackTrace")
    @GetMapping("date")
    public ResponseEntity<Map<String, Double>> findByPlateDate(@PathVariable  String plateDate){
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date pd= formatter.parse(plateDate);
            //@DateTimeFormat(pattern = "dd/MM/yyyy")
            List<Menu> menuList=this.mService.findByPlateDate(pd);
            Map<String,Double>menuData=new HashMap<>();
            if(!menuList.isEmpty()){
                for(int i=0; i<menuList.size();i++){
                    String name=menuList.get(i).getPlateName();
                    Double price=menuList.get(i).getPrice();
                    menuData.put(name,price);
                }
                return ResponseEntity.ok(menuData);
            }else{
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping("/createPlate")
    public ResponseEntity<Menu> createPlate(@RequestBody Menu menu){
        Menu m=mService.save(menu);
        menu.toString();
        return ResponseEntity.ok(m);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Menu> updatePlate(@PathVariable Long id, @RequestBody Menu menu){
        Menu newMenu =mService.findById(id);
        newMenu.setPlateName(menu.getPlateName());
        newMenu.setPlateDate(menu.getPlateDate());
        newMenu.setPrice(menu.getPrice());

        return ResponseEntity.ok(mService.save(newMenu));
    }
}