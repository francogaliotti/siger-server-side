package com.SIGER.SIGER.sendgrid;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailSendGridService {

    @Value("${app.sendgrid.key}")
    private String appkey;

    /*@Value("${app.sendgrid.templateId}")
    private String templateId;*/

    @Autowired
    SendGrid sendGrid;

    private String remitente = "SIGERUTN@gmail.com";

    private String destinatario;

    private String asunto = "Bienvenida al Sistema";

    private String mensaje = "Se ha registrado exitosamente como usuario."
            +"\n" +"Le damos la bienvenida al sistema, muchas gracias por suscribirse";

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public void sendWelcomeEmail() throws IOException {

        Email from = new Email();
        from.setEmail(remitente);
        String subject = asunto;
        Email to = new Email();
        to.setEmail(this.destinatario);
        Content content = new Content("text/plain", mensaje);
        Mail mail = new Mail(from, subject, to, content);
        //mail.setTemplateId(templateId);

        SendGrid sg = new SendGrid(appkey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
    }

}
