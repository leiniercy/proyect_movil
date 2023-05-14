/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thymleaf.movil.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thymleaf.movil.entity.Movil;

/**
 * @author leinier
 * @Repository NOTACION DE SPRING (BEAN) QUE GARANTIZA QUE LA CLASE SE COMPORTE
 *             COMO UN REPOSITORIO
 * @JpaRepository<Object,Identificador> API DE JAVA PARA TRADUCIR DEL LENGUAJE
 *                                      DE PROGRAMACION A SQL
 **/

@Repository
public interface MovilRepository extends JpaRepository<Movil, Long> {
    /**
     * findBy buscar por el nombre del atributo del objeto la primera letra debe ser
     * mayuscula
     **/
    //Busqueda por nombre y modelo
    public Optional<Movil> findByNombreAndModelo(String nombre, String modelo);
    //Busqueda por nombre o modelo
    public Optional<Movil> findByNombreOrModelo(String nombre, String modelo);
}
