/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thymleaf.movil.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author leinier
 */
// Modelo de usuario
@Entity // Para decir que sera la entidad a mapear por el ORM
@Table(name = "movil") // Le asignamos un nombre de tabla
@Getter // Lombok para evitar crear los métodos get de forma manual
@Builder // Para usar el patrón builder
@Setter // Lombok para evitar crear los métodos set de forma manual
@AllArgsConstructor  // Lombok para evitar crear el constructor con todos los argumentos de forma manual
@NoArgsConstructor // Lombok para evitar crear el constructor sin los argumentos de forma manual
public class Movil {

    @Id // Declaramos que este campo va a ser el identificador
    @GeneratedValue(generator = "UUID") // Será generado de forma automática
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    ) // Tipo de estrategia a utilizar para autegeneral el campo
    private String id;
    private String nombre;
    private String pantalla;
    private String procesador;
    private Integer ram;
    private String almacenamiento;
    private Integer camaraTrasera;
    private Integer camaraFrontal;
    private Long bateria;
    private String sensores;
    private String seguridad;
    private String conectividad;
    private String otros;
    private String sistemaOperativo;
    private Float precio;

}
