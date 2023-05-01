/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thymleaf.movil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thymleaf.movil.entity.Movil;

/**
 *
 * @author leinier
 */

@Repository
public interface MovilRepository extends JpaRepository<Movil, String>{
    
}
