package pl.coderslab.medical_devices_query_system.mail;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class SendEmail {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(String comments, String emailBcc) throws IOException, TemplateException, MessagingException {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("classpath:templates/mail/templates");

        Configuration configuration = freeMarkerConfigurer.createConfiguration();
        Template mailTemplate = configuration.getTemplate("completeEmail.ftlh");
        Map<String, Object> model = new HashMap<>();
        model.put("comments", comments);
        String mailBody = FreeMarkerTemplateUtils.processTemplateIntoString(mailTemplate, model);

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);


        messageHelper.setFrom("emailsenderportal@gmail.com");
        messageHelper.setSubject("Projekt został ukończony");
        messageHelper.setBcc("agnieszka.sieminska@gmail.com");
        messageHelper.setText(mailBody, true);

        mailSender.send(mimeMessage);

    }
}
