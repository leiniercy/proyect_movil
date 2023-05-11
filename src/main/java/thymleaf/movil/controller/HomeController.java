package thymleaf.movil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import thymleaf.movil.Service.MovilService;

@Controller// Le decimos que es un constrolador
@RequestMapping("/")// Hacemos un mapeo general del controlador o sea, definimos una url base
public class HomeController {

    @Autowired // utilizamos el patron singelton para crear un pto de acceso global
    MovilService movilService;

    // Definimos un método GET para el path test/ o sea, lo primero que aparece cuando entras a la url test
    @RequestMapping(method = RequestMethod.GET, name = "test", path = "/")
    public String firstReturn(Model model){
        // model.addAttribute("movilList", movilService.findAll());
        return "layout"; // Retornamos la dirección al template principal, en este caso layout
    }



}
