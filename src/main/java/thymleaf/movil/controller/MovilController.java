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
import thymleaf.movil.repository.MovilRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author leinier
 */
@Controller // Le decimos que es un controlador
public class MovilController {

    @Autowired // utilizamos el patron singelton para crear un pto de acceso global
    MovilService movilService;

    private static final String VIEW = "/layout.html";
    private static final String REDIRECT = "redirect:/movil";

    @RequestMapping(method = RequestMethod.GET, name = "getPageMovil", path = "/movil")
    public String getPageMovil(
            Model model) {     
                // model.addAttribute("movil", new Movil());
                model.addAttribute("movilList", movilService.findAll());
        return "layout";
    }

    /** @ModelAttribute Movil movil concide con el valor del th:object del formulario**/ 
    // @PostMapping(value = "path")
    // public String newAndUpdate(
    //     @Valid @ModelAttribute("movil") Movil movil, 
    //     BindingResult result,
    //     ModelMap modelMap) {
    //         if(result.hasErrors()){
    //             modelMap.addAttribute("movil", movil);
    //         }
    //     // movilService.save(movil);
    //     return "layout/_movil_form";
    // }

}
