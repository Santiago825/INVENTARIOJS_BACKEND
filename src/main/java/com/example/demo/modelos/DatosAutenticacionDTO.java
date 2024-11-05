package com.example.demo.modelos;
/*
 * Copyright (c) 2023.
 * @Plataforma: IT2Pay
 * @Sistema: Portal Administrativo
 * @Modulo: Portal Administrativo Frontend
 * @Copyright IT2Ex
 *
 * @Autor: nromero
 * @FechaCreación: 9/5/2023
 */

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Repository
public class DatosAutenticacionDTO {

    private static final long serialVersionUID = 5558830820971548283L;

    private String usuario;

    @ToString.Exclude
    private String usuarioContr;

    /** The codigo respuesta. */
    private String codigoRespuesta;

    /** The descripcion respuesta. */
    private String mensajeRespuesta;

}
