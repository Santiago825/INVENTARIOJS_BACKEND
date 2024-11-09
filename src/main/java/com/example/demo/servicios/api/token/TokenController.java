package com.example.demo.servicios.api.token;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelos.DatosAutenticacionDTO;
import com.example.demo.modelos.DatosBasicosUsuarioDTO;
import com.example.demo.modelos.TokenDTO;
import com.example.demo.servicios.servicio.token.ServicioValidacionUsuario;
import com.example.demo.util.otros.constantes.config.ConstantesCodigosError;
import com.example.demo.util.otros.constantes.path.ConstantesSeguridadPathRest;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.*;

@RestController
public class TokenController {

    @Value("${security.jwt.token.secret-key}")
    private String secretKey;

    @Value("${security.jwt.token.expire-length}")
    private long validityInMilliseconds;

    @Autowired
    private ServicioValidacionUsuario servicioValidacionUsuario;

    @RequestMapping(value = ConstantesSeguridadPathRest.PATH_TOKEN, method = RequestMethod.POST, headers = "Accept=" + MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<TokenDTO> getToken(@RequestBody DatosAutenticacionDTO datos) throws Exception {

        TokenDTO respuesta = null;

        try {
            DatosAutenticacionDTO datoSalida = servicioValidacionUsuario.validarUsuario(datos);
            System.out.println(datoSalida);
            respuesta = new TokenDTO();

            respuesta.setCodigoRespuesta(datoSalida.getCodigoRespuesta());
            respuesta.setMensajeRespuesta(datoSalida.getMensajeRespuesta());

            if (respuesta.getCodigoRespuesta().equals(ConstantesCodigosError.CODIGO_EXITO)) {
                String username = datos.getUsuario();
                String password = datos.getUsuarioContr();

                DatosBasicosUsuarioDTO usuarioSesion = new DatosBasicosUsuarioDTO();
                usuarioSesion.setLogin(username);

                List<String> roles = new ArrayList<>();
                roles.add("USER_ROLE");

                Map<String, Object> claims = new HashMap<>();

                // Asegurarse de que la clave secreta tenga al menos 256 bits (32 bytes)
                byte[] keyBytes = secretKey.getBytes();
                if (keyBytes.length < 32) {
                    // Si la clave es más corta que 256 bits, completarla con caracteres adicionales
                    // hasta que tenga 32 bytes
                    keyBytes = Arrays.copyOf(keyBytes, 32); // Extiende la clave a 256 bits
                } else if (keyBytes.length > 32) {
                    // Si la clave es más larga que 256 bits, recortarla a 32 bytes
                    keyBytes = Arrays.copyOfRange(keyBytes, 0, 32); // Truncar la clave a 256 bits
                }

                // Crear la clave secreta con la longitud correcta
                Key key = new SecretKeySpec(keyBytes, SignatureAlgorithm.HS512.getJcaName());

                // Crear el token con la clave secreta
                System.out.println("peso");

                String token = Jwts.builder()
                        .setClaims(claims)
                        .setSubject(username + ";zAz;" + password)
                        .setIssuedAt(new Date(System.currentTimeMillis()))
                        .setExpiration(new Date(System.currentTimeMillis() + validityInMilliseconds))
                        .signWith(key)  // Firmar el JWT con la clave secreta (Key)
                        .compact();
                System.out.println("mensjajes");
                respuesta.setToken(token);
                respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_EXITO);
                respuesta.setMensajeRespuesta(ConstantesCodigosError.MENSAJE_CODIGO_EXITO);

                return new ResponseEntity<TokenDTO>(respuesta, HttpStatus.OK);
            } else {
                if (respuesta.getMensajeRespuesta() == null || respuesta.getMensajeRespuesta().trim().equals("")) {
                    respuesta.setMensajeRespuesta(ConstantesCodigosError.MENSAJE_NO_ESPECIFICADO);
                }

                return new ResponseEntity<TokenDTO>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            respuesta = new TokenDTO();
            respuesta.setCodigoRespuesta(ConstantesCodigosError.CODIGO_ERROR_NO_CONTROLADO);
            respuesta.setMensajeRespuesta(ConstantesCodigosError.MENSAJE_CODIGO_ERROR_NO_CONTROLADO);

            return new ResponseEntity<TokenDTO>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
