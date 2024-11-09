package com.example.demo.servicios.servicio.token;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.accesoDatos.AutenticacionMapper;
import com.example.demo.modelos.DatosAutenticacionDTO;
import com.example.demo.modelos.DatosBasicosUsuarioDTO;
import com.example.demo.util.otros.constantes.config.ConstantesCodigosError;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Service
public class ServiciosValidacionUsuarioImpl implements ServicioValidacionUsuario {

    private SimpleDateFormat formato = new SimpleDateFormat("hh:mm:ss");

  

    @Autowired
    private AutenticacionMapper autenticacionMapper;

   
    public DatosAutenticacionDTO validarUsuario(DatosAutenticacionDTO usuario) throws Exception {


        long currentTimeMillis = System.currentTimeMillis();
        Date horaInicio = new Date();

        DatosAutenticacionDTO salida = null;

        try{
            

            if(usuario == null ||
                    usuario.getUsuario() == null ||
                    usuario.getUsuarioContr() == null ||
                    usuario.getUsuario().trim().equals("") ||
                    usuario.getUsuarioContr().trim().equals("")){
                salida = new DatosAutenticacionDTO();


                salida.setCodigoRespuesta(ConstantesCodigosError.CODIGO_ERROR_USU_PWD_SVC);
                salida.setMensajeRespuesta(ConstantesCodigosError.MENSAJE_ERROR_USU_PWD_SVC);
                return salida;
            }
            System.out.println("sanlchica");
            System.out.println(usuario);
            salida = autenticacionMapper.autenticacion(usuario.getUsuario());

            if(salida.getUsuario().equals(usuario.getUsuario()) &&
                    salida.getUsuarioContr().equals(usuario.getUsuarioContr())){
                salida.setUsuario(null);
                salida.setUsuarioContr(null);
                salida.setCodigoRespuesta(ConstantesCodigosError.CODIGO_EXITO);
                salida.setMensajeRespuesta(ConstantesCodigosError.MENSAJE_CODIGO_EXITO);
            } else {
                salida = new DatosAutenticacionDTO();


                salida.setCodigoRespuesta(ConstantesCodigosError.CODIGO_ERROR_USU_PWD_NOVAL);
                salida.setMensajeRespuesta(ConstantesCodigosError.MENSAJE_ERROR_USU_PWD_NOVAL);
                return salida;
            }

        } catch (Exception e) {

            throw e;

        } finally {
            Date horaFin = new Date();
           
        }

        return salida;
    }


    public synchronized String format(Date date) {
        TimeZone timeZone = TimeZone.getTimeZone("GMT-5");
        formato.setTimeZone(timeZone);
        return formato.format(date);
    }

}