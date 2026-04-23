package es.iesclaradelrey.da2d1a.tiendarmgaos.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Clase de configuración. @Configuration -> Spring la carga al arrancar.
// Implementamos WebMvcConfigurer para poder tocar cosas del MVC.
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    // Atajo para páginas "estáticas" que no necesitan lógica en un Controller.
    // En vez de crear un controller entero solo para devolver el HTML,
    // mapeamos la URL directamente a la vista.
    // "/condiciones-uso" -> muestra templates/condiciones-uso.html
    @Override
    public void addViewControllers(ViewControllerRegistry registro) {
        registro.addViewController("/condiciones-uso")
                .setViewName("condiciones-uso");
    }
}
