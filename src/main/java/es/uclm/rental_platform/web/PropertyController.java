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

@Controller
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/properties/new")
    public String newProperty(@RequestParam(defaultValue = "false") boolean created, Model model) {
        model.addAttribute("propertyForm", new PropertyForm());
        model.addAttribute("created", created);
        return "property-form";
    }

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