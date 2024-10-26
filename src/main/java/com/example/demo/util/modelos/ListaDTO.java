package com.example.demo.util.modelos;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@ToString
@Repository
@Setter
@Getter
public class ListaDTO implements Serializable{

    /** Constante serialVersionUID. */
    private static final long serialVersionUID = -1389651088866793664L;
    /** Constante codigo. */
    private String codigoRespuesta;
    /** Constante mensaje. */
    private String mensajeRespuesta;
    /** total paginas**/
    private int totalRegistros;
    /** total paginas**/
    private int totalPaginas;
    /** Constante lista. */
    private List<?> lista;
	
    
    
    
	

}
