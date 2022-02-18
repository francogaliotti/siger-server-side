package com.SIGER.SIGER.emailSender.controller;

import com.SIGER.SIGER.common.Message;
import com.SIGER.SIGER.common.PasswordValidation;
import com.SIGER.SIGER.emailSender.dto.ChangeAndResetPasswordDTO;
import com.SIGER.SIGER.emailSender.dto.EmailValuesDTO;
import com.SIGER.SIGER.emailSender.service.EmailService;
import com.SIGER.SIGER.security.entity.Usuario;
import com.SIGER.SIGER.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/email-password")
@CrossOrigin
public class EmailController {

  @Autowired
  EmailService emailService;

  @Autowired
  UsuarioService usuarioService;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Value("${spring.mail.username}")
  String mailFrom;

  @Value("${mail.subject-welcome}")
  String subject_Welcome;

  @Value("${mail.subject-Reset-Password}")
  String subject_Reset_Password;

  @Value("${mail.subject-Change-Password}")
  String subject_Change_Password;

  @PostMapping("/send-welcome-email")
  public ResponseEntity<?> sendWelcomeEmail(@RequestBody EmailValuesDTO valuesDTO){
    Optional<Usuario> usuarioOptional = usuarioService.getByUsernameOrCorreoInstitucional(valuesDTO.getUsername());
    if(!usuarioOptional.isPresent()){
      return new ResponseEntity<>(new Message("No existe ningún usuario con esas credenciales"),
              HttpStatus.NOT_FOUND);
    }

    Usuario usuario = usuarioOptional.get();
    valuesDTO.setMailFrom(mailFrom);
    valuesDTO.setSubject(subject_Welcome);

    UUID uuid = UUID.randomUUID();
    String tokenPassword = uuid.toString();

    valuesDTO.setTokenPassword(tokenPassword);
    usuario.setTokenPassword(tokenPassword);

    usuarioService.save(usuario);
    System.out.println("Email Controller: " + valuesDTO.getMailTo());
    emailService.sendWelcomeEmail(valuesDTO);

    return new ResponseEntity<>(new Message("Te hemos enviado un correo"), HttpStatus.OK);
  }

  @PostMapping("/send-email")
  public ResponseEntity<?> sendResetPasswordEmail(@RequestBody EmailValuesDTO valuesDTO){
    Optional<Usuario> usuarioOptional = usuarioService.getByUsernameOrCorreoInstitucional(valuesDTO.getMailTo());
    if(!usuarioOptional.isPresent()){
      return new ResponseEntity<>(new Message("No existe ningún usuario con esas credenciales"),
          HttpStatus.NOT_FOUND);
    }

    Usuario usuario = usuarioOptional.get();
    valuesDTO.setMailFrom(mailFrom);
    valuesDTO.setMailTo(usuario.getCorreoInstitucional());
    valuesDTO.setSubject(subject_Reset_Password);
    valuesDTO.setUsername(usuario.getUsername());

    UUID uuid = UUID.randomUUID();
    String tokenPassword = uuid.toString();

    valuesDTO.setTokenPassword(tokenPassword);
    usuario.setTokenPassword(tokenPassword);

    usuarioService.save(usuario);
    emailService.sendResetPasswordEmail(valuesDTO);

    return new ResponseEntity<>(new Message("Te hemos enviado un correo"), HttpStatus.OK);
  }

  @PostMapping("/send-change-password-email")
  public ResponseEntity<?> sendChangePasswordEmail(@RequestBody EmailValuesDTO valuesDTO){
    Optional<Usuario> usuarioOptional = usuarioService.getByUsernameOrCorreoInstitucional(valuesDTO.getMailTo());
    if(!usuarioOptional.isPresent()){
      return new ResponseEntity<>(new Message("No existe ningún usuario con esas credenciales"),
              HttpStatus.NOT_FOUND);
    }

    Usuario usuario = usuarioOptional.get();
    valuesDTO.setMailFrom(mailFrom);
    valuesDTO.setMailTo(usuario.getCorreoInstitucional());
    valuesDTO.setSubject(subject_Change_Password);
    valuesDTO.setUsername(usuario.getUsername());

    UUID uuid = UUID.randomUUID();
    String tokenPassword = uuid.toString();

    valuesDTO.setTokenPassword(tokenPassword);
    usuario.setTokenPassword(tokenPassword);

    usuarioService.save(usuario);
    emailService.sendChangePasswordEmail(valuesDTO);

    return new ResponseEntity<>(new Message("Te hemos enviado un correo"), HttpStatus.OK);
  }

  @PostMapping("/change-password")
  public ResponseEntity<?> resetPassword(@Valid@RequestBody ChangeAndResetPasswordDTO changeAndResetPasswordDTO,
                                         BindingResult bindingResult){
    if(bindingResult.hasErrors()){
      return new ResponseEntity<>(new Message("Campos mal puestos"), HttpStatus.BAD_REQUEST);
    }
    if(!changeAndResetPasswordDTO.getPassword().equals(changeAndResetPasswordDTO.getConfirmPassword())){
      return new ResponseEntity<>(new Message("Las contraseñas no coinciden"), HttpStatus.BAD_REQUEST);
    }
    if(!PasswordValidation.isValid(changeAndResetPasswordDTO.getPassword()))
      return new ResponseEntity<>(new Message("La contraseña debe tener como mínimo 8 caracteres"), HttpStatus.BAD_REQUEST);

    Optional<Usuario>usuarioOptional = usuarioService.findByTokenPassword(changeAndResetPasswordDTO.getTokenPassword());
    if(!usuarioOptional.isPresent()){
      return new ResponseEntity<>(new Message("No existe ningún usuario con esas credenciales"),
          HttpStatus.NOT_FOUND);
    }

    Usuario usuario = usuarioOptional.get();
    String newPassword = passwordEncoder.encode(changeAndResetPasswordDTO.getPassword());
    usuario.setPassword(newPassword);
    usuario.setTokenPassword(null);
    usuario.setPasswordExpireDate(LocalDateTime.now().plusMonths(6));
    usuarioService.save(usuario);
    return new ResponseEntity<>(new Message("Contraseña actualizada"), HttpStatus.OK);
  }

}
