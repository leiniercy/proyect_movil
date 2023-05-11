/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thymleaf.movil.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @GeneratedValue(strategy = GenerationType.AUTO) // Será generado de forma automática
    private Integer id;

    @NotBlank(message = "Este campo es obligatorio") //permmite validar que no sea nulo y q tenga al menos un caracter
    @Size(min = 2, max=255, message = "No cumple con las reglas del tamaño") //validacion de tamaño, minimo 2 caracteres , maximo 255 caracteres
    private String nombre;
    //principales caracteristicas
    @NotBlank(message = "Este campo es obligatorio") //permmite validar que no sea nulo y q tenga al menos un caracter
    private String pantalla;
    @NotBlank(message = "Este campo es obligatorio") //permmite validar que no sea nulo y q tenga al menos un caracter
    private String procesador;
    @NotBlank(message = "Este campo es obligatorio") //permmite validar que no sea nulo y q tenga al menos un caracter
    private String modelo;
    //almacenamiento
    @NotNull //Cuando se utilizan campos con tipo de datos primitivos se utliza esta notacion que indica lo mismo q el @NotBlank
    private Integer ram;
    @NotNull //Cuando se utilizan campos con tipo de datos primitivos se utliza esta notacion que indica lo mismo q el @NotBlank
    private Integer rom;
    //Camaras
    @NotNull //Cuando se utilizan campos con tipo de datos primitivos se utliza esta notacion que indica lo mismo q el @NotBlank
    private Integer camaraTrasera;
    @NotNull //Cuando se utilizan campos con tipo de datos primitivos se utliza esta notacion que indica lo mismo q el @NotBlank
    private Integer camaraFrontal;
    //Conectividad
    @NotBlank(message = "Este campo es obligatorio") //permmite validar que no sea nulo y q tenga al menos un caracter
    private String banda2G; //GSM
    @NotBlank(message = "Este campo es obligatorio") //permmite validar que no sea nulo y q tenga al menos un caracter
    private String banda3G; //LATAM UMTS
    @NotBlank(message = "Este campo es obligatorio") //permmite validar que no sea nulo y q tenga al menos un caracter
    private String banda4G; //LTE LATAM;
    //Bateria
    @NotNull //Cuando se utilizan campos con tipo de datos primitivos se utliza esta notacion que indica lo mismo q el @NotBlank
    private Long bateria;
    //Otros
    @NotBlank(message = "Este campo es obligatorio") //permmite validar que no sea nulo y q tenga al menos un caracter
    private String wifi;
    @NotBlank(message = "Este campo es obligatorio") //permmite validar que no sea nulo y q tenga al menos un caracter
    private String sim;
    @NotBlank(message = "Este campo es obligatorio") //permmite validar que no sea nulo y q tenga al menos un caracter
    private String sensores;
    //Precio
    @NotNull //Cuando se utilizan campos con tipo de datos primitivos se utliza esta notacion que indica lo mismo q el @NotBlank
    private Float precio;
    //Kit de venta
    private String kitVenta;

}
