package com.SIGER.SIGER.emailSender.service;

import com.SIGER.SIGER.emailSender.dto.EmailValuesDTO;
import java.util.HashMap;
import java.util.Map;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailService {

  @Autowired
  JavaMailSender javaMailSender;

  @Autowired
  TemplateEngine templateEngine;

  @Value("${mail.url-Change-Password}")
  String url_Change_Password;

  public void sendEmail(EmailValuesDTO emailValuesDTO){
    MimeMessage message = javaMailSender.createMimeMessage();
    try {
      MimeMessageHelper helper = new MimeMessageHelper(message,true);
      Context context = new Context();
      Map<String, Object> model = new HashMap<>();
      model.put("username", emailValuesDTO.getUsername());
      model.put("url", url_Change_Password + emailValuesDTO.getTokenPassword());
      context.setVariables(model);

      String htmlText = templateEngine.process("email-template", context);

      helper.setFrom(emailValuesDTO.getMailFrom());
      helper.setTo(emailValuesDTO.getMailTo());
      helper.setSubject(emailValuesDTO.getSubject());
      helper.setText(htmlText,true);
      javaMailSender.send(message);
    }catch (MessagingException e){
      e.printStackTrace();
    }
  }


}
