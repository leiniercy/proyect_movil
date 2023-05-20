/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thymleaf.movil.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import thymleaf.movil.Service.MovilService;
import thymleaf.movil.entity.Movil;
import thymleaf.movil.exeptions.MovilNameOrIdNotFound;
import thymleaf.movil.repository.MovilRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author leinier
 */
@Controller // Le decimos que es un controlador
public class MovilController {

    @Autowired // utilizamos el patron singelton para crear un pto de acceso global
    MovilService movilService;

    private static final String VIEW = "layout";
    private static final String REDIRECT = "redirect:/movil";
    private Long id = (long) -1;

    @GetMapping(path = "/movil")
    public String getPageMovil(
            Model model) {
        model.addAttribute("movil", new Movil());
        model.addAttribute("movilList", movilService.findAll());
        return VIEW;
    }

    /**
     *  @Valid se encarga de verificar las validadciones de los campos de la entidad
     *  @ModelAttribute Movil movil concide con el valor del th:object del formulario
     **/

    @PostMapping(path = "/movil")
    public String newAndUpdate(
            @Valid @ModelAttribute("movil") Movil movil,
            BindingResult result,
            ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("movil", movil);
        } else {
            try {
                if (this.id == -1) {
                    movil.setId(id);
                    movilService.save(movil);
                    model.addAttribute("movil", new Movil());
                    model.addAttribute("movilList", movilService.findAll());
                }

            } catch (Exception e) {
                // le pasamos al HTML la excepcion encontrada al guradar un objeto de tipo movil
                model.addAttribute("formErrorMessage", e.getMessage());
                model.addAttribute("movil", movil);
                model.addAttribute("movilList", movilService.findAll());
            }
        }

        return VIEW;
    }

    /**
     *   @PathVariable(name = "id") Long id se encarga de llamar al id desde la vista
     **/
    @GetMapping(value = "/movil/edit/{id}")
    public String update(
            @PathVariable(name = "id") Long id,
            Model model) throws MovilNameOrIdNotFound {
        Movil oldMovil = movilService.findById(id);
        model.addAttribute("movilList", movilService.findAll());
        model.addAttribute("movil", oldMovil);
        model.addAttribute("editMode", "true");
        
        return VIEW;
    }

    @PostMapping("/movil/edit")
	public String postEditMovilForm(@Valid @ModelAttribute("movil")Movil movil, BindingResult result, Model model) {
		//Si tiene errores
        if (result.hasErrors()) {
            model.addAttribute("movil", movil);
            model.addAttribute("editMode", "true");
        } else {
            try {
                    movilService.update(movil);
                    model.addAttribute("movil", new Movil());
                    model.addAttribute("movilList", movilService.findAll());
             } catch (MovilNameOrIdNotFound e) {
                // le pasamos al HTML la excepcion encontrada al guradar un objeto de tipo movil
                model.addAttribute("formErrorMessage", e.getMessage());
                model.addAttribute("movil", movil);
                model.addAttribute("movilList", movilService.findAll());
                model.addAttribute("editMode", "true");
            }
        }

        return VIEW;
		
	}
	
	@GetMapping("/movil/cancel")
	public String cancelEditUser(ModelMap model) {
		return REDIRECT;
	}

    @GetMapping("/movil/delete/{id}")
	public String deleteMovil(Model model, @PathVariable(name="id") Long id) {
		try {
			movilService.deleteById(id);
		} catch (MovilNameOrIdNotFound e) {
			model.addAttribute("deleteError","El objeto no puede ser eliminado.");
		}
		return getPageMovil(model);
	}


}
