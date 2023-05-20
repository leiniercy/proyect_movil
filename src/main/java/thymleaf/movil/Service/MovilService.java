package thymleaf.movil.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thymleaf.movil.entity.Movil;
import thymleaf.movil.exeptions.MovilNameOrIdNotFound;
import thymleaf.movil.repository.MovilRepository;

/**
 * @Leinier
 * @Service //NOTACION DE SPRING (BEAN) QUE INDICA QUE ESTA CLASE SE VA A CONTENER UN CONJUNTO DE SERVICIOS
 */

@Service 
public class MovilService {

    @Autowired //UTILIZAZACION DEL PATRON SINGELTON PARA CREAR UN PTO DE ACCESO GLOBAL
    MovilRepository repository;

    /**
     * METODO PARA VERIFICAR SI EL OBJETO ESTA DISPONIBLE O NO
     * @param entity indica el objeto que se desea guradar. No debe ser vacio {@literal null}.
     * @return true/false
     **/
    private boolean checkMovilAvailable(Movil movil) throws MovilNameOrIdNotFound {
        Optional<Movil> movilFound = repository.findById(movil.getId());
        if (movilFound.isPresent()) {
            throw new MovilNameOrIdNotFound("Móvil no disponible");
        }
        return true;
    }

    /**
     * PRIMERO SE VERIFICA QUE EL OBJETO NO EXISTA, Y LUEGO SE GURADA LA INFORMACION
     * @param entity indica el objeto que se desea guradar. No debe ser vacio {@literal null}.
     * @return el objeto guardado
     **/
    public Movil save(Movil movil) throws MovilNameOrIdNotFound {
        if (checkMovilAvailable(movil)) {
            movil = repository.save(movil);
        }
        return movil;
    }

     /**
     * Map todo 
     * @param from
     * @return to
     **/
    public Movil update(Movil fromMovil) throws MovilNameOrIdNotFound {
        Movil toMovil = findById(fromMovil.getId());
        //Mapeo del objeto para garantizar que se actualicen todos los cambios
        toMovil.setNombre(fromMovil.getNombre());


        return repository.save(toMovil);
    }

    /**
     * METODO PARA VERIFICAR SI EL MOVIL EXISTE, PREGUNTANDO POR EL ID
     * @param id no debe ser vacio {@literal null}.
	 * @return una referencia a la entidad que coincida con el identificador.
     **/
    public Movil findById(Long id) throws MovilNameOrIdNotFound{
       Movil movil =repository.findById(id).orElseThrow(() -> new MovilNameOrIdNotFound("El id de este movil no existe."));
        return movil;
    }

    /**
     * METODO QUE DEVUELVE UNA LISTA CON TODOS LOS OBJETOS DE UN MISMO TIPO ESPECIFICADO PREVIAMENTE
     * @return  un listado de objetos
     **/
    public List<Movil> findAll() {
        return repository.findAll();
    }

    /**
	 * METODO PARA ELIMINAR UN OBJETO POR SU IDENTIFICADOR
     * @param Objeto
	 **/
    public void delete(Movil movil) {
        repository.delete(movil);
    }

    /**
	 * METODO PARA ELIMINAR UN OBJETO POR SU IDENTIFICADOR
     * @param Identificador
	 **/
    public void deleteById(Long id) throws MovilNameOrIdNotFound{
       Movil movil = findById(id);
       repository.delete(movil);
    }

    /**
	 * METODO PARA ELIMINAR UN CONJUNTO DE OBJETOS.
     * @param Set<Object>
	 **/
    public void deleteAll(Set<Movil> moviles) {
        repository.deleteAll(moviles);
    }

    // METODO QUE DEVUELVE LA CANTIDAD DE OBJETOS QUE EXISTE
    public long count() {
        return (long) repository.count();
    }

}
