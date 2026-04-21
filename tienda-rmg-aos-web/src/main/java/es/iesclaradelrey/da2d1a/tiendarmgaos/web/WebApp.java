package es.iesclaradelrey.da2d1a.tiendarmgaos.web;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// Esta es la clase que arranca toda la app de Spring Boot.
// Como tenemos 2 módulos (web y common), le decimos con scanBasePackages
// que busque componentes (@Controller, @Service, @Repository...) en los dos.
// Si no lo hiciéramos, Spring solo miraría en el paquete de esta clase y no
// encontraría el service ni el repositorio del módulo common.
@SpringBootApplication(scanBasePackages = {
 "es.iesclaradelrey.da2d1a.tiendarmgaos.web",
 "es.iesclaradelrey.da2d1a.tiendarmgaos.common"
})
@EnableJpaRepositories(basePackages = "es.iesclaradelrey.da2d1a.tiendarmgaos.common.repositories")
@EntityScan(basePackages = "es.iesclaradelrey.da2d1a.tiendarmgaos.common.entities")
public class WebApp {
    // El main de toda la vida -> aquí empieza todo cuando le das al play
    public static void main(String[] args) {
        SpringApplication.run(WebApp.class, args);
    }
}
