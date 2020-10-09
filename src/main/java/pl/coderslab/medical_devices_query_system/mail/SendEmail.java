package pl.coderslab.medical_devices_query_system.mail;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import pl.coderslab.medical_devices_query_system.model.dbFIle.DbFile;
import pl.coderslab.medical_devices_query_system.model.project.Project;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class SendEmail {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(Project project, String comments, String emailBcc) throws IOException, TemplateException, MessagingException {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("classpath:templates/mail/templates");

        Configuration configuration = freeMarkerConfigurer.createConfiguration();
        Template mailTemplate = configuration.getTemplate("completeEmail.ftlh");
        Map<String, Object> model = new HashMap<>();
        model.put("comments", comments);
        model.put("projectCompleted", project);
        String mailBody = FreeMarkerTemplateUtils.processTemplateIntoString(mailTemplate, model);

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

        messageHelper.setFrom("emailsenderportal@gmail.com");
        messageHelper.setSubject("Projekt został ukończony");
        messageHelper.setBcc(new String[]{"emailsenderportal@gmail.com", emailBcc});
        messageHelper.setText(mailBody, true);

        List<DbFile> files = project.getFiles();
        for (DbFile file : files) {
            ByteArrayResource byteArrayFile = new ByteArrayResource(file.getData());
            messageHelper.addAttachment(file.getOriginalFileName(), byteArrayFile);
        }
        mailSender.send(mimeMessage);
    }
}


