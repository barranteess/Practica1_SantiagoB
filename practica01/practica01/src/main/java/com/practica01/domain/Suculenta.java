/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica01.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@Data
@Entity
@Table(name = "suculenta")
public class Suculenta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_suculenta")
    private Integer idSuculenta;

    @NotBlank(message = "El nombre común es obligatorio.")
    @Size(max = 60, message = "El nombre común no puede superar 60 caracteres.")
    @Column(name = "nombre_comun", nullable = false, length = 60)
    private String nombreComun;

    @NotBlank(message = "El nombre científico es obligatorio.")
    @Size(max = 80, message = "El nombre científico no puede superar 80 caracteres.")
    @Column(name = "nombre_cientifico", nullable = false, length = 80)
    private String nombreCientifico;

    @NotBlank(message = "La familia es obligatoria.")
    @Size(max = 50, message = "La familia no puede superar 50 caracteres.")
    @Column(name = "familia", nullable = false, length = 50)
    private String familia;

    @NotBlank(message = "El color principal es obligatorio.")
    @Size(max = 40, message = "El color no puede superar 40 caracteres.")
    @Column(name = "color_principal", nullable = false, length = 40)
    private String colorPrincipal;

    @NotNull(message = "La altura es obligatoria.")
    @Min(value = 1, message = "La altura debe ser mayor a 0.")
    @Max(value = 500, message = "La altura no puede superar 500 cm.")
    @Column(name = "altura_cm", nullable = false)
    private Integer alturaCm;

    @NotNull(message = "El precio estimado es obligatorio.")
    @DecimalMin(value = "0.0", message = "El precio no puede ser negativo.")
    @Column(name = "precio_estimado", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioEstimado;

    @NotBlank(message = "Seleccione el nivel de riego.")
    @Pattern(regexp = "Bajo|Moderado|Alto", message = "El nivel de riego debe ser Bajo, Moderado o Alto.")
    @Column(name = "nivel_riego", nullable = false, length = 10)
    private String nivelRiego;

    @NotBlank(message = "La URL de la imagen es obligatoria.")
    @Size(max = 1024, message = "La URL no puede superar 1024 caracteres.")
    @Pattern(regexp = "^https?://.+", message = "Debe ser un enlace de internet que inicie con http:// o https://")
    @Column(name = "ruta_imagen", nullable = false, length = 1024)
    private String rutaImagen;
}