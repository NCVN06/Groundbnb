package es.uclm.rental_platform.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Gestiona las solicitudes de la página principal de la aplicación.
 */
@Controller
public class HomeController {

    /**
     * Muestra la página principal.
     *
     * @return nombre lógico de la vista de la página principal
     */
    @GetMapping("/")
    public String home() {
        return "home";
    }
}