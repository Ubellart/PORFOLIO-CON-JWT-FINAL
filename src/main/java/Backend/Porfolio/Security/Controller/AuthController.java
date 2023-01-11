/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend.Porfolio.Security.Controller;

import Backend.Porfolio.Security.Dto.JwtDto;
import Backend.Porfolio.Security.Dto.LoginUsuario;
import Backend.Porfolio.Security.Dto.NuevoUsuario;
import Backend.Porfolio.Security.Entity.Rol;
import Backend.Porfolio.Security.Entity.Usuario;
import Backend.Porfolio.Security.Enums.RolNombre;
import Backend.Porfolio.Security.Jwt.JwtProvider;
import Backend.Porfolio.Security.Service.RolService;
import Backend.Porfolio.Security.Service.UsuarioService;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author victo
 */
@RestController

@RequestMapping("/auth")
@CrossOrigin(origins ={"https://porfolio-ublellart.web.app","http://localhost:4200"})
public class AuthController {

    @Autowired    
private PasswordEncoder passwordEncoder;
//    @Autowired
//    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;
    
    
   // nuevo usuario
    
    @PostMapping("/nuevo")
    
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario,BindingResult bindingResult){
       
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos invalidos"),HttpStatus.BAD_REQUEST);
    
    if (usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
        return new ResponseEntity(new Mensaje("nombre de usuario ya existe"),HttpStatus.BAD_REQUEST);
    
    
//    if (usuarioService.existsByEmail(nuevoUsuario.getEmail()))
//        return new ResponseEntity(new Mensaje(" ese email ya existe"),HttpStatus.BAD_REQUEST);
//   Usuario usuario = new Usuario(nuevoUsuario.getNombre(),nuevoUsuario.getNombreUsuario(),nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));
     Usuario usuario = new Usuario(nuevoUsuario.getNombreUsuario(), passwordEncoder.encode(nuevoUsuario.getPassword()));
   Set<Rol> roles = new HashSet<>();
   roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
   
    if(nuevoUsuario.getRoles().contains("admin"))
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
    
    usuario.setRoles(roles);
    usuarioService.save(usuario);
    return new ResponseEntity( new Mensaje("Usuario Guardado"), HttpStatus.CREATED);
    }
    
    
    //Login
    
    @PostMapping("/login")
    
     public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario,BindingResult bindingResult){
    
        if(bindingResult.hasErrors())
            return  new ResponseEntity(new Mensaje("Campos mal puestos"),HttpStatus.BAD_REQUEST);
        
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(),loginUsuario.getPassword()));
        
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt= jwtProvider.generateToken(authentication);
        
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        
        JwtDto jwtDto = new JwtDto (jwt,userDetails.getUsername(),userDetails.getAuthorities());
    
    return new ResponseEntity(jwtDto, HttpStatus.OK);
    
    }
     
@DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable int id) {

          usuarioService.borrar(id);
    }
    
}
