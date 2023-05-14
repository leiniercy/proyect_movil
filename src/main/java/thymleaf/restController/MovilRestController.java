package thymleaf.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import thymleaf.movil.entity.Movil;
import thymleaf.movil.repository.MovilRepository;

@RestController
@RequestMapping("/api/movil")
@CrossOrigin
public class MovilRestController {
    
    @Autowired
    MovilRepository movilRepository;

    @GetMapping(value="/")
    public List<Movil> getMoviles() {
        return movilRepository.findAll();
    }

    @GetMapping(value="/{id}")
    public Movil geMovil(@PathVariable Long id) {
        return movilRepository.findById(id).orElse(null);
    }

    @PostMapping(value="/")
    public Movil addMovil(@RequestBody Movil movil) {
        return movilRepository.save(movil);
    }

    @PutMapping(value="/")
    public Movil updateMovil(@RequestBody Movil movil) {
        Movil oldMovil = movilRepository.findById(movil.getId()).orElse(null);
        oldMovil.setNombre(movil.getNombre());
        //faltan atributos
        
        return movilRepository.save(oldMovil);
    }
    
    @DeleteMapping(value="/{id}")
    public Long deleteUserById (@PathVariable Long id){
        movilRepository.deleteById(id);
        return id;
    }
    

}
