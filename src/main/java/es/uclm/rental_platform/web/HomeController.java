package es.uclm.rental_platform.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.uclm.rental_platform.domain.Property;
import es.uclm.rental_platform.service.PropertyService;

/**
 * Gestiona las solicitudes de la página principal de la aplicación.
 */
@Controller
public class HomeController {

    private final PropertyService propertyService;

    public HomeController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    /**
     * Muestra el catálogo de propiedades y, si se indica, los resultados de una
     * búsqueda por texto.
     *
     * @param query texto opcional para buscar propiedades
     * @param model modelo que se completa con las propiedades y la consulta
     * @return nombre lógico de la vista de la página principal
     */
    @GetMapping("/")
    public String home(@RequestParam(required = false) String query, Model model) {
        boolean searchSubmitted = query != null;
        String searchText = searchSubmitted ? query : "";
        boolean hasQuery = !searchText.isBlank();

        List<Property> properties = searchSubmitted && !hasQuery
                ? List.of()
                : propertyService.searchProperties(searchText);
        model.addAttribute("properties", properties);
        model.addAttribute("query", searchText);
        model.addAttribute("searchSubmitted", searchSubmitted);
        model.addAttribute("hasQuery", hasQuery);
        return "home";
    }
}