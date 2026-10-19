package es.uclm.rental_platform.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.uclm.rental_platform.service.PropertyService;
import jakarta.validation.Valid;

/**
 * Gestiona las solicitudes web para mostrar y enviar registros de propiedades.
 */
@Controller
public class PropertyController {

    /** Servicio encargado de crear y persistir propiedades. */
    private final PropertyService propertyService;

    /**
     * Crea el controlador con el servicio de propiedades indicado.
     *
     * @param propertyService servicio utilizado para registrar propiedades
     */
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    /**
     * Muestra el formulario para registrar una propiedad.
     *
     * @param created indica si el registro anterior se completó correctamente
     * @param model modelo que se completa con el formulario y el estado del registro
     * @return nombre lógico de la vista de registro de propiedades
     */
    @GetMapping("/properties/new")
    public String newProperty(@RequestParam(defaultValue = "false") boolean created, Model model) {
        model.addAttribute("propertyForm", new PropertyForm());
        model.addAttribute("created", created);
        return "property-form";
    }

    /**
     * Valida y procesa el envío del registro de una propiedad.
     *
     * @param propertyForm valores de la propiedad enviados en el formulario
     * @param bindingResult resultados de validación asociados a
     *        {@code propertyForm}
     * @param redirectAttributes atributos que se incluirán en la solicitud de
     *        redirección
     * @return la vista del formulario si falla la validación, o una redirección al
     *         formulario tras completar el registro
     * @throws org.springframework.dao.DataAccessException si no se puede persistir
     *         la propiedad
     */
    @PostMapping("/properties")
    public String createProperty(@Valid @ModelAttribute("propertyForm") PropertyForm propertyForm,
            BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "property-form";
        }

        propertyService.createProperty(
                propertyForm.getTitle(),
                propertyForm.getDescription(),
                propertyForm.getAddress(),
                propertyForm.getCity(),
                propertyForm.getPricePerNight(),
                propertyForm.getAmenities(),
                propertyForm.getType(),
                propertyForm.getInstantBooking());

        redirectAttributes.addAttribute("created", true);
        return "redirect:/properties/new";
    }
}