package com.example.primerProyectoSerbatic_actualizacion1;
import com.example.primerProyectoSerbatic_actualizacion1.repository.MenuRepository;
import com.example.primerProyectoSerbatic_actualizacion1.entity.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.Date;
@SuppressWarnings({"deprecation", "MagicConstant"})
@SpringBootApplication
public class PrimerProyectoSerbaticActualizacion1Application {

	@SuppressWarnings("MagicConstant")
	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(PrimerProyectoSerbaticActualizacion1Application.class, args);

		var repo=context.getBean(MenuRepository.class);

		//System.out.println(repo.count());
		/*Date fecha = new Date(new java.util.Date(124, 2, 12).getTime()); //12-03-2024
		repo.save(new Menu(null,fecha,"poke bowl",7.99));
		repo.save(new Menu(null,fecha,"canelones",5.99));
		repo.save(new Menu(null,fecha,"paella",6.50));
		repo.save(new Menu(null,fecha,"lentejas",7.55));

		Date fecha2 = new Date(new java.util.Date(124, 2, 13).getTime()); //13-03-2024
		repo.save(new Menu(null,fecha2,"pasta carbonara",8.75));
		repo.save(new Menu(null,fecha2,"pizza",7.00));
		repo.save(new Menu(null,fecha2,"ramen",8.25));
		repo.save(new Menu(null,fecha2,"pasta boloñesa",8.55));

		Date fecha3 = new Date(new java.util.Date(124, 2, 14).getTime()); //14-03-2024
		repo.save(new Menu(null,fecha3,"filetes empanados",6.98));
		repo.save(new Menu(null,fecha3,"kebab",5.30));
		repo.save(new Menu(null,fecha3,"ensalada",4.98));
		repo.save(new Menu(null,fecha3,"arroz con pollo",5.60));*/
		//repo.deleteAll();

		System.out.println(repo.findAll());
		System.out.println(repo.count());
		System.out.println(repo.findById(6L)); //filtrar por id

		Date fechaBusqueda = new Date(new java.util.Date(124, 2, 13).getTime());
		System.out.println(repo.findByPlateDate(fechaBusqueda)); //filtrar por fecha
	}
}